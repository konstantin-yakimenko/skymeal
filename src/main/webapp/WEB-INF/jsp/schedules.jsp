<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/scheduleDatatables.js" defer></script>



<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="schedules.title"/></h3>

            <div class="view-box">
                <a class="btn btn-sm btn-info" onclick="add('planes.add')"><spring:message code="schedules.add"/></a>

                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Number</th>
                        <th>Region date</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<%--action="/skymeal/ajax/admin/schedules/file"--%>
<div class="container">
    <form id="form2" method="post" enctype="multipart/form-data">
        <input name="file2" id="file2" type="file" /><br/>
    </form>
    <button value="Submit" onclick="uploadFormData()" >Upload</button><i>Using FormData Object</i>
    <%--<div id="result"></div>--%>
    <%--
        <form method="POST" enctype="multipart/form-data" id="fileUploadForm">
            <input type="text" name="extraField"/><br/><br/>
            <input type="file" name="files"/><br/><br/>
            <input type="file" name="files"/><br/><br/>
            <input type="submit" value="Submit" id="btnSubmit"/>
        </form>
    --%>
    <%--
        <form id="form2" method="post" action="/spring-mvc-file-upload/rest/cont/upload" enctype="multipart/form-data">
            <input name="file2" id="file2" type="file" /><br/>
        </form>

        <button value="Submit" onclick="uploadJqueryForm()" >Upload</button><i>Using JQuery Form Plugin</i><br/>
        <button value="Submit" onclick="uploadFormData()" >Upload</button><i>Using FormData Object</i>
    --%>
    <%--
        <h3>Select file to upload</h3>
        <p>
            <input type="number" name="chunkSize" id="chunkSize" th:value="${chunkSize}"/><br/><br/>
            <input type="file" name="fileToUpload" id="fileToUpload"><br/>
        </p>
        <p>
            <input type="submit" value="Upload" name="submit">
        </p>
    --%>
</div>


<jsp:include page="fragments/footer.jsp"/>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="date" class="control-label col-xs-3">Date</label>
                        <div class="col-xs-9">
                            <input class="form-control" id="date" name="date" placeholder="Date">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="number" class="control-label col-xs-3">Type</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="number" name="number" placeholder="Number">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="button" onclick="save()" class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    <jsp:include page="fragments/i18n.jsp"/>
</script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
</html>