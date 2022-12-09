<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/12/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Facility</title>
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
</head>
<body>
<form method="post">
    <select id="elements" onchange="showValue()" name="facilityType" class="btn-primary">
        <option value="1" selected>Villa</option>
        <option value="2" >House</option>
        <option value="3" >Room</option>
    </select>
    <div id="results"></div>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
<script>
    let fom1 = "<div class=\"row\" >\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "    <div class=\"col-md-6\" style=\"background: #e9f2ef\">\n" +
        "        <h1 class=\"text-center\">Add Facility Villa</h1>\n" +
        "        <form method=\"post\">\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Name Facility</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"nameFacility\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Area</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"area\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Cost</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"cost\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Max People</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"maxPeople\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Rent Type</label>\n" +
        "                <select class=\"form-select\" name=\"rentType\">\n" +
        "                    <option value=\"1\">Year</option>\n" +
        "                    <option value=\"2\">Month</option>\n" +
        "                    <option value=\"3\">Day</option>\n" +
        "                    <option value=\"4\">Hour</option>\n" +
        "                </select>\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Standard Room</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"standardRoom\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">description Other Convenience</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"descriptionOtherConvenience\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Pool Area</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"poolArea\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Number Of Floors</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"numberOfFloors\">\n" +
        "            </div>\n" +
        "        </form>\n" +
        "    </div>\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "</div>";

    let fom2 = "<div class=\"row\" >\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "    <div class=\"col-md-6\" style=\"background: #e9f2ef\">\n" +
        "        <h1 class=\"text-center\">Add Facility House</h1>\n" +
        "        <form method=\"post\">\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Name Facility</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"nameFacility\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Area</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"area\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Cost</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"cost\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Max People</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"maxPeople\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Rent Type</label>\n" +
        "                <select class=\"form-select\" name=\"rentType\">\n" +
        "                    <option value=\"1\">Year</option>\n" +
        "                    <option value=\"2\">Month</option>\n" +
        "                    <option value=\"3\">Day</option>\n" +
        "                    <option value=\"4\">Hour</option>\n" +
        "                </select>\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Standard Room</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"standardRoom\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">description Other Convenience</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"descriptionOtherConvenience\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Number Of Floors</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"numberOfFloors\">\n" +
        "            </div>\n" +
        "        </form>\n" +
        "    </div>\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "</div>";

    let fom3 = "<div class=\"row\" >\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "    <div class=\"col-md-6\" style=\"background: #e9f2ef\">\n" +
        "        <h1 class=\"text-center\">Add Facility Room</h1>\n" +
        "        <form method=\"post\">\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Name Facility</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"nameFacility\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Area</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"area\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Cost</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"cost\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Max People</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"maxPeople\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Rent Type</label>\n" +
        "                <select class=\"form-select\" name=\"rentType\">\n" +
        "                    <option value=\"1\">Year</option>\n" +
        "                    <option value=\"2\">Month</option>\n" +
        "                    <option value=\"3\">Day</option>\n" +
        "                    <option value=\"4\">Hour</option>\n" +
        "                </select>\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Standard Room</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"standardRoom\">\n" +
        "            </div>\n" +
        "            <div class=\"mb-3\">\n" +
        "                <label class=\"form-label fw-bold\">Facility Free</label>\n" +
        "                <input type=\"text\" class=\"form-control\" name=\"facilityFree\">\n" +
        "            </div>\n" +
        "        </form>\n" +
        "    </div>\n" +
        "    <div class=\"col-md-3\"></div>\n" +
        "</div>";

    document.getElementById("results").innerHTML = fom1;

    function showValue() {
        var ele = elements.value;
        if (ele == 1) {
            document.getElementById("results").innerHTML = fom1;
        } else if (ele == 2) {
            document.getElementById("results").innerHTML = fom2;
        } else {
            document.getElementById("results").innerHTML = fom3;
        }
    }
</script>

<script src="../../bootstrap/js/bootstrap.js"></script>
</body>
</html>
