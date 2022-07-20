<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Report<title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px}
.button-update {background-color: #008CBA; color white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
    <h2>Prueba Tecnica Planilla Empleados </h2>
    <div style=:"margin-top: 40px";>
        <s:if test="noData==true">
            <table>
                <thead>
                    <tr style="background-color: #E0E0E1;">
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Edad</th>
                        <th>Sexo</th>
                        <th>Servicio Profesional</th>
                        <th>Salario</th>
                    </tr>
                </thead>
                <s:iterator value="empList">
                    <tr>
                        <td><s:property value="i" /><td>
                        <td><s:property value="Nombres" /><td>
                        <td><s:property value="Apellidos" /><td>
                        <td><s:property value="Edad" /><td>
                        <td><s:property value="Sexp" /><td>
                        <td><s:property value="ServiciosProfesionales" /><td>
                        <td><s:property value="Salario" /><td>
                            <a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="uemail"/>">
                                <button class="button-update">Update</button>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            <div style="color: red;">No Data Found..</div>
        </s:else>
    </div>
</body>
</html>
