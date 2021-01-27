<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <section>
    <h1>프로젝트 등록</h1>

    <table border="1">
      <tbody>
        <tr>
            <select 
            style="width: 900px; height: 30px;">
            <option value=""  selected disabled hidden>필드선택</option>
            <option value="웹">웹</option>
            <option value="게임">게임</option>
        </select> 
    </tr>
    <tr>
        <th>스킬선택</th>
        <td>
            <input type="checkbox">JSP
        </td>

    </tr>
    <tr>
        <th>언어선택</th>
        <td>
            <input type="checkbox">자바
        </td>

    </tr>
    <tr>
       <th>제목</th>
       <td><input type="text" style="width: 825px"></td>
   

    </tr>

     <tr>
        <th>첨부파일</th>
        <td><input type="file"></td>
        
 
     </tr>
     <tr>
        <td colspan="4">
            <textarea 
                style="width: 900px; height: 500px; "></textarea>
        </td>
    </tr>
  <tr>
        <td colspan="4">
            <textarea 
                style="width: 900px; height: 100px; " placeholder="요구조건"></textarea>
        </td>
    </tr>
    
</tbody>

    </table>
    </section>

</body>
</html>