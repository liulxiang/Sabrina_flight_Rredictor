<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/jquery.multiselect2side.css"/>" />
<div class="row first-row">
</div>

<select name="firstSelect[]" id='first' multiple='multiple' >
				<optgroup label="Group1">
					<option value="1">First Option</option>
					<option value="2">Option 2th</option>
					<option value="3" SELECTED >Option selected 3</option>
				</optgroup>
					<optgroup label="Group 10-19">
						<option value="14">Option 14</option>
						<option value="15">Option 15</option>
						<option value="16">Option 16</option>
						<option value="17" SELECTED >Option selected 17</option>
						<option value="18">Option 18</option>
					</optgroup>
					<optgroup label="Group 20-29">
						<option value="24">Option 24</option>
						<option value="25">Option 25</option>
						<option value="26">Option 26</option>
						<option value="27" SELECTED >Option selected 27</option>
						<option value="28">Option 28</option>
					</optgroup>
					<optgroup label="Group 30-39">
						<option value="34">Option 34</option>
						<option value="35">Option 35</option>
						<option value="36">Option 36</option>
						<option value="37">Option 37</option>
						<option value="38">Option 38</option>
					</optgroup>
					<optgroup label="Group 40-49">
						<option value="41">Option 41</option>
						<option value="42">Option 42</option>
						<option value="43">Option 43</option>
						<option value="44">Option 44</option>
						<option value="45">Option 45</option>
						<option value="46">Option 46</option>
						<option value="47">Option 47</option>
						<option value="48">Option 48</option>
				</optgroup>
				</select>
<script type="text/javascript" src="../resources/js/jquery.multiselect2side.js" charset="UTF-8"></script>
<!-- Initialize the plugin: -->
<script type="text/javascript">
  $(document).ready(function() {
	  $('#first').multiselect2side({
			optGroupSearch: "Group: ",
			search: "<img src='../resources/img/search.gif' />"
		});
  });

</script>