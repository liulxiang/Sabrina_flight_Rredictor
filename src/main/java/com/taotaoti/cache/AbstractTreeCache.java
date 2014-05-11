package com.taotaoti.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractTreeCache<ID, T extends Comparable<T>> implements ITreeCache<ID, T> {

	private Map<ID, T> _id2self;
	private Map<ID, List<T>> _parentId2Children;
	private List<ID> _rootIds;

	/**
	 * 调用该方法可以初始化或者更新缓存，具体实现需保证线程安全
	 * <p>
	 * 
	 * @param dataList
	 */
	@Override
	public void initOrUpdate(List<T> dataList) {
		final Map<ID, T> id2self = new HashMap<ID, T>();
		final Map<ID, List<T>> parentId2Children = new HashMap<ID, List<T>>();
		List<ID> rootIds = new ArrayList<ID>();
		if (dataList != null && !dataList.isEmpty()) {
			for (T t : dataList) {
				ID parentId = getParentId(t);
				if (parentId == null) {
					rootIds.add(getId(t));
					continue;
				}
				List<T> list = parentId2Children.get(parentId);
				if (list == null) {
					list = new ArrayList<T>();
					parentId2Children.put(parentId, list);
				}
				list.add(t);
			}
			
			for (T t : dataList) {
				ID id = getId(t);
				id2self.put(id, t);
				
				//加入独立节点到parentId2Children
				ID parentId = getParentId(t);
				if (parentId == null && parentId2Children.get(id) == null) {
					List<T> list = new ArrayList<T>();
					list.add(t);
					parentId2Children.put(id, list);
				}
			}
		}
		
		//顺序排
		Collections.sort(rootIds, new Comparator<ID>() {
			@Override
			public int compare(ID o1, ID o2) {
				T t1 = id2self.get(o1);
				T t2 = id2self.get(o2);
				
				if(t1 == null && t2 == null){
					return 0;
				}
				if(t1 == null){
					return 1;
				}
				return t2.compareTo(t1);
			}
		});
		
		synchronized (this) {
			//保证数据的一致性
			_id2self = id2self;
			_parentId2Children = parentId2Children;
			_rootIds = rootIds;
		}
	}

	@Override
	public T get(ID id) {
		// 避免去map中getForNullKey
		if (id == null) {
			return null;
		}
		return _id2self.get(id);
	}

	@Override
	public T getParent(ID id) {
		T t = this.get(id);
		if (t == null) {
			return null;
		}
		ID parentId = getParentId(t);
		// 避免去map中getForNullKey
		if (parentId == null) {
			return null;
		}
		return _id2self.get(parentId);
	}

	@Override
	public List<T> getChildren(ID parentId) {
		// 避免去map中getForNullKey
		if (parentId == null) {
			return null;
		}
		return _parentId2Children.get(parentId);
	}

	/**
	 * 完成如下功能：
	 * <ul>
	 * <li>剔除不合法性的id</li>
	 * <li>剔除不该被选择的id，判断一个节点是否应该选择，规则如下：</li>
	 * <ol>
	 * <li>如果该节点为子节点，当其仅当其兄弟节点不完全选择时选择</li>
	 * <li>如果该节点为父节点，当其仅当其所有子节点都选择时选择</li>
	 * </ol>
	 * </ul>
	 * <p>
	 * <p>
	 * @param all
	 */
	public List<ID> elimTree(List<ID> all) {
		if (all == null || all.size() == 0) {
			return null;
		}
		Set<ID> set = new HashSet<ID>(all.size());
		set.addAll(all);
		
		List<ID> ret = new ArrayList<ID>();
		for (ID id : all) {
			if (isValidAndNeedSelected(set, id)) {
				ret.add(id);
			}
		}

		return ret;
	}

	/**
	 * 完成如下功能：
	 * <ul>
	 * <li>完成一个id合法性的校验</li>
	 * <li>判断一个节点是否应该选择</li>
	 * <ol>
	 * <li>如果该节点为子节点，当其仅当其兄弟节点不完全选择时选择</li>
	 * <li>如果该节点为父节点，当其仅当其所有子节点都选择时选择</li>
	 * </ol>
	 * </ul>
	 * <p>
	 * @param all
	 * @param id
	 * @return
	 */
	private boolean isValidAndNeedSelected(Set<ID> all, ID id) {
		if (all == null || all.size() == 0 || id == null) {
			return false;
		}

		T t = _id2self.get(id);
		if (t == null) {
			// 在cache中根本不存在，不合法，直接返回false
			return false;
		}

		List<T> list = _parentId2Children.get(id);
		// 判断是否是父节点
		if (list == null || list.isEmpty()) {
			// 是叶子节点，那么还得判断其兄弟节点是否全选
			T parent = getParent(id);
			if (parent == null) {
				// 是叶子节点，却没父节点，那么该节点为独立节点
				return true;
			} else {
				ID parentId = getId(parent);

				// 如果所有其兄弟节点全选，那么就应该不被选择
				if (isValidAndNeedSelected(all, parentId)) {
					// 如果parentid需要选择，那么自己就不需要选择了
					return false;
				}
			}
		} else {
			// 如果是父节点，得判断所有的子点是否全选
			if (list.size() > all.size()) {
				// 如果子节点的数量已经大于选择的数量，说明子节点没有被全选，那么父节点无效
				return false;
			}else {
				for (T child : list) {
					ID childId = getId(child);
					if(childId == id){
						//独立节点
						continue;
					}
					// 只要有一个孩子没选择，那么父节点就该排除
					if (!all.contains(childId)) {
						// 表示该父节点的至少一个子节点没有被包含，那么父节点自然不该被选
						return false;
					} else {
						if (isParentId(childId)
								&& !isValidAndNeedSelected(all, childId)) {
							// 如果该子节点仍然是父节点，那么递归的判断其不该被选择
							return false;
						}
						// 如果是不是父节点，那么就不需要再判断
					}
				}
			}
		}

		return true;
	}

	/**
	 * 将所有的父节点都扩充到子节点（包含父节点）
	 * <p>
	 * By Xiaohu 2013-5-16 下午1:24:30
	 * 
	 * @param all
	 * @return
	 */
	public List<ID> expandToChildren(List<ID> all) {
		List<ID> ret = new ArrayList<ID>();
		if (all == null || all.isEmpty()) {
			return ret;
		}

		for (ID id : all) {
			T t = get(id);
			// 校验合法性
			if (t == null) {
				continue;
			}
			ret.add(id);
			List<T> children = getChildren(id);
			if (children != null && children.size() > 0) {
				List<ID> perentChildIds = new ArrayList<ID>();
				for (T child : children) {
					// getId(child)不需要校验合法性，因为是从children=_parentId2Children.get(parentId);
					ID childId = getId(child);
					if(childId == id){
						//独立节点
						continue;
					}
					ret.add(childId);
					
					List<T> childrens = getChildren(childId);
					if(childrens != null && childrens.size() > 0){
						perentChildIds.add(childId);
					}
				}
				List<ID> expandedIds = expandToChildren(perentChildIds);
				if (!expandedIds.isEmpty()) {
					ret.addAll(expandedIds);
				}
			}else{
			   ID parentId = getParentId(t);
			   if(parentId != null && !ret.contains(parentId)){
				   ret.add(parentId);
			   }
			}
		}

		return ret;
	}

	public boolean isParentId(ID id) {
		if (id == null) {
			return false;
		}
		List<T> list = _parentId2Children.get(id);
		if (list == null || list.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<ID> getRootIds(){
		return _rootIds;
	}
	
	@Override
	public Map<ID, T> getId2Self() {
		//该Map只读，不能修改
		return Collections.unmodifiableMap(_id2self);
	}

	@Override
	public Map<ID, List<T>> getParentId2Children() {
		//该Map只读，不能修改
		return Collections.unmodifiableMap(_parentId2Children);
	}

	/**
	 * 通过节点获取该节点的标识id
	 * 
	 * <p>
	 * @param t
	 * @return
	 */
	public abstract ID getId(T t);

	/**
	 * 通过节点获取其父节点id
	 * 
	 * <p>
	 * @param t
	 * @return
	 */
	public abstract ID getParentId(T t);
}
