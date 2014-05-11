package com.taotaoti.cache;

import java.util.List;
import java.util.Map;

public interface ITreeCache<ID,T>{
	
	/**
	 * 调用该方法可以初始化或者更新缓存，具体实现需保证线程安全
	 * <p>
	 *
	 * @param dataList
	 */
	void initOrUpdate(List<T> dataList);

	/**
	 * 根据id获取对应的缓存对象
	 * <p>
	 *
	 * @param id
	 * @return
	 */
	T get(ID id);
	
	/**
	 * 根据id获取对应缓存中其父节点
	 * <p>
	 * @param id
	 * @return
	 */
	T getParent(ID id);
	
	/**
	 * 根据父id获取对应的缓存中的所有子节点
	 * <p>
	 * @param parentid
	 * @return
	 */
	List<T> getChildren(ID parentid);
	
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
	 * By Xiaohu 2013-5-16 下午4:38:59
	 * 
	 * @param all
	 */
	List<ID> elimTree(List<ID> all);
	
	/**
	 * 将所有的父节点都扩充到子节点（包含父节点）
	 * <p>
	 * @param all
	 * @return
	 */
	List<ID> expandToChildren(List<ID> all);
	
	/**
	 * 将所有的父节点
	 * <p>
	 * @return
	 */
	List<ID> getRootIds();
	
	/**
	 * 获取节点id到节点的映射
	 * <p>
	 * @return
	 */
	Map<ID, T> getId2Self();
	
	/**
	 * 获取父节点id到其子节点的映射
	 * <p>
	 * @return
	 */
	Map<ID, List<T>> getParentId2Children();
}
