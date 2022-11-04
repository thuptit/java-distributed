<%-- 
    Document   : index
    Created on : Nov 3, 2022, 9:51:03 PM
    Author     : thunv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid h-100">
            <div class="row">
                <div class="col-6">
                    <div class="row">
                        <form id="form-subject">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Subject ID</label>
                                <input type="text" class="form-control" id="SubjectID">
         
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Subject Code</label>
                                <input type="text" class="form-control" id="SubjectCode">
         
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Subject Name</label>
                                <input type="text" class="form-control" id="SubjectName">
         
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Faculty</label>
                                <input type="text" class="form-control" id="Faculty">
         
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Credit</label>
                                <input type="text" class="form-control" id="Credit">
         
                            </div>
                            <button type="button" onclick="createSubject()" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
                <div class="col-6">
                    <div class="row">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
//        $(document).ready(function () {
//            console.log("ready!");
//            subjects();
//        });
        const subjects = () => {
            $.ajax({
                url: '/distributed-webapp/getSubjects',
                type: 'GET',
                success: (res) => {
                    console.log(res);
                }
            })
        }
        const createSubject = () => {
            var $form = $('#form-subject').find('form');
            console.log($form.serialize());
            $.ajax({
                url: '/distributed-webapp/createSubject',
                type: 'POST',
                data: {
                    SubjectID: $('#SubjectID').val(),
                    SubjectCode: $('#SubjectCode').val(),
                    SubjectName: $('#SubjectName').val(),
                    Faculty: $('#Faculty').val(),
                    Credit: $('#Credit').val()
                },
                success: (res) => {
                    console.log(res);
                }
            })
        }
    </script>
    </body>
    
</html>
