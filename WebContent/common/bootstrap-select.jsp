<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-multiselect.css"/>" />
<div class="row first-row">
</div>

<select class="multiselect" multiple="multiple">
  <option value="cheese">Cheese</option>
  <option value="tomatoes">Tomatoes</option>
  <option value="mozarella">Mozzarella</option>
  <option value="mushrooms">Mushrooms</option>
  <option value="pepperoni">Pepperoni</option>
  <option value="onions">Onions</option>
</select>
 
<script type="text/javascript" src="../resources/js/bootstrap-multiselect.js" charset="UTF-8"></script>
<!-- Initialize the plugin: -->
<script type="text/javascript">
  $(document).ready(function() {
    $('.multiselect').multiselect();
  });
</script>