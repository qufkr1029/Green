window.onload = function(){ // 화면이 로드된 후 자동으로 실해되는 영역 => 현재 시스템 날짜에 맞는 달력 생성
    let now = new Date(); // 2021년 12월 23일 오후 5시 25분~~~~ => [2021년 12월 1일(1일에 해당하는 요일)] 
    let nowMonth = new Date(now.getFullYear(), now.getMonth());
    // [2021년 12월 1일(1일에 해당하는 요일)0시 0분 0초] 

    changeHead(nowMonth);
    buildCalendar(nowMonth);

}

function selectMonth(){ //input태그를 통해 입력받는 날짜에 맞는 달력 생성
    let yeatMonth = document.getElementById('selectMonth').value;
    let selectYeatMonth = new Date(yeatMonth);
    // 선택된 년도 선택된 월 1일 0시 0분 0초;

    changeHead(selectYeatMonth);
    buildCalendar(selectYeatMonth);

}

function changeHead(selectDate){ // 현재 작성중인 캘린더의 년월을 화면에 표기
    let head = document.getElementById('head');
    head.innerHTML = selectDate.getFullYear +"년 " + selectDate.getMonth +"월"
}

function buildCalendar(){ // 실제 달력을 작성하는 함수

}

function lastDate(){ // 해당 월의 마지막 날자를 알려주는 함수

}

