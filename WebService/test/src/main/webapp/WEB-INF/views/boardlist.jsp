<%@page import="project.board.DTO.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="resources/css/style.css">
	</head>

	<% // <BoardDTO> list = (List<BoardDTO>)request.getAttribute("list"); %>
	
	<body>
	<h1>게시판</h1>
	<table>
		<thead>
			<tr>
				<th id="thIndex">글 번호</th>
				<th id="thTitle">글 제목</th>
				<th id="thWriter">작성자</th>
				<th id="thDate">조회수</th>
				<th id="thCount">날짜</th>
			</tr>
		</thead>
		<tbody id="boardBody">
		</tbody>
	</table>
	<div style="text-align: right; grid-template-columns: 1">
			<input type="button" value="글쓰기" onclick="" style="grid: 1">
	</div>
</body>

<script>
				var htmlWrite = '';
				var list = ${list};
				console.log(list);
				
				for(var i=0; i<list.length; i++){
					
					htmlWrite = htmlWrite + '<tr>';
					
					const keys = Object.keys(list[i])
					for (const key of keys) {
					  if(key === 'board_content')
						  continue;
					  else{
						
						  htmlWrite = htmlWrite + '<td>';
							
						  if(key === 'board_title'){
							  htmlWrite = htmlWrite +'<a href=\'writeBoardContent.do?'+'content=' + list[i]['board_content'] +'&index='+ list[i]['board_index'] + '\'>' + list[i][key]+'</a>';  
						  }
						  else if(key ==='board_index'){
							  htmlWrite = htmlWrite + (i+1);
						  }
						  else{
							  htmlWrite = htmlWrite + list[i][key];
						  }
					  

						htmlWrite = htmlWrite + '</td>';
						
					  }
					}
					htmlWrite = htmlWrite + '</tr>';
				}
				
				document.getElementById('boardBody').innerHTML = htmlWrite;
			</script>

</html>