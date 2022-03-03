<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MINI SNS</title>
<script src="jQuery/jquery-3.6.0.js"></script>
</head>
<body>
    <h2>MINI SNS</h2>
    <table border="1"> 
    	<thead>
        <tr>
            <th>번호</th>
            <th>글제목</th>
            <th>글 내용</th>
            <th>날짜</th>
        </tr>
        </thead>
        <tbody id="tbl">
        
        </tbody>
        
    </table>
    <section>
        <form action="" method="POST">
            <table>
                <tr>
                    <td colspan="2">
                        <label>글 제목 <input type="text" name="title" id="title"></label>
                        <input type="hidden" name="code" value="${code}">
                    </td>
                </tr>
                <tr>
                    <td rowspan="2"><textarea name="contents" id="contents" cols="30" rows="10" placeholder="글 내용"></textarea></td>
                    <td><input type="button" value="등록" onclick="registContents()"></td>
                </tr>
                <tr>
                    <td><input type="button" value="수정" onclick="changeContents()"></td>
                </tr>
            </table>
        </form>
    </section>

    <script>
        window.onload = function(){
            $.ajax({
                type:"GET",
                async:true,
                url:"registText",
                dataType:"JSON",
                success:function(wordList){
                    console.log(wordList[0]);
                   let tbl = document.getElementById('tbl');
                   tbl.innerHTML="";
                     for(let i=0;i<wordList.length;i++){
                    	let tr = document.createElement('tr');
                        let td1 = document.createElement('td');
                        td1.innerHTML=wordList[i].code;
                        let td2 = document.createElement('td');
                        td2.innerHTML=wordList[i].title;
                        let td3 = document.createElement('td');
                        td3.innerHTML=wordList[i].contents;
                        let td4 = document.createElement('td');
                        td4.innerHTML=wordList[i].regDate;

                        tr.appendChild(td1);
                        tr.appendChild(td2);
                        tr.appendChild(td3);
                        tr.appendChild(td4);

                        tbl.appendChild(tr);
                    }
                    
                },
                error:function(){
                    alert("에러가 발생했습니다.");
                }
            });
        }

        function registContents(){
            let title = $('#title').val();
            let contents = $('#contents').val();

            let wordData = {
                "title":title,
                "contents":contents
            }

            $.ajax({
                type:"POST",
                async:true,
                url:"registText",
                data:{
                    "wordData":JSON.stringify(wordData)
                },dataType:"JSON",
                success:function(wordList){
                    console.log(wordList[0]);
                   let tbl = document.getElementById('tbl');
                   tbl.innerHTML="";
                    for(let i=0;i<wordList.length;i++){
                    	let tr = document.createElement('tr');
                        let td1 = document.createElement('td');
                        td1.innerHTML=wordList[i].code;
                        let td2 = document.createElement('td');
                        td2.innerHTML=wordList[i].title;
                        let td3 = document.createElement('td');
                        td3.innerHTML=wordList[i].contents;
                        let td4 = document.createElement('td');
                        td4.innerHTML=wordList[i].regDate;

                        tr.appendChild(td1);
                        tr.appendChild(td2);
                        tr.appendChild(td3);
                        tr.appendChild(td4);

                        tbl.appendChild(tr);
                    }
                    
                },
                error:function(){
                    alert("에러가 발생했습니다.");
                }
            });
        }

    </script>
</body>
</html>