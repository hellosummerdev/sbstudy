
// html이 랜더링 되었을 때 동작하는 함수
window.onload = async () => { // onload : 문서에 포함된 모든 페이지 구성요소(css, img등)가 로드된 후에 실행된다.
    await fnGetBoardList(); // 이 함수 실행될때까지 아래로 내려가지마라, 순서를 보장해준다
}

//jquery
//$(document).ready(function)

async function fnGetBoardList(){
    console.log("fnGetBoardList 실행");

//    첫번째 await
//    fetch : 브라우저에 내장된 비동기 함수. lib설치 필요 없음
    let response = await fetch('/board/list', {
        method : 'post',
//        body : JSON.stringfy({user_id : test, user_pwd : 1234}) // <- 컨트롤러 파라미터에 해당
//        headers :{
//            'Content-Type' : 'application/json'
//        }
//            'Content-Type' : 'application/x-www-form-urlencoded'},
    });

    // 두번째 await
    // json으로 달라고 했으니까 json 준다
    response = await response.json();

    console.log(response);
    console.log(response.status); // response['status']
    console.log(response.data);

    // 200이 아니면 함수 끝남
    if(response['status'] !== 200){
        return null;
    }

    // 화면 그리기
    const boardArr = response.data;
    const htmlArr = [];
    for(let i=0; i < boardArr.length; i++) {
        const html = `<tr>
                        <td>${boardArr[i]['board_title']}</td>
                        <td>${boardArr[i]['board_content']}</td>
                        <td>${boardArr[i]['user_id']}</td>
                        <td>${boardArr[i]['created_at']}</td>
                </tr>`;
        htmlArr.push(html);
    }

//    v1 jQuery
    $("#tbody").append(htmlArr.join(""));
//    console.log(htmlArr);

//    v2 js
//    document.getElemenById()....

}



