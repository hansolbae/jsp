<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>팜스토리</title>
    <link rel="stylesheet" href="../css/style.css"/>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <a href="../index.html"><img src="../img/logo.png" alt="로고"></a>
        <p>
          <a href="#">HOME |</a>
          <a href="#">회원가입 |</a>
          <a href="#">로그인 |</a>
          <a href="#">로그아웃 |</a>
          <a href="#">고객센터</a>
        </p>

        <img src="../img/head_txt_img.png" alt="3만원이상 무료배송/팜카드 10%적립" />

        <ul>
          <li><a href="#">팜스토리소개</a></li>
          <li><a href="#"><img src="../img/head_menu_badge.png" alt="badge"/>장보기</a></li>
          <li><a href="#">농작물이야기</a></li>
          <li><a href="#">이벤트</a></li>
          <li><a href="#">커뮤니티</a></li>
        </ul>

      </header>
      <section id="sub" class="introduction">
        <div><img src="../img/sub_top_tit1.png" alt="INTRODUCTION"></div>
        <section>
          <aside>
            <img src="../img/sub_aside_cate1_tit.png" alt="팜스토리소개"/>
            <ul class="lnb">
              <li><a href="./hello.html">인사말</a></li>
              <li class="on"><a href="./direction.html">찾아오시는길</a></li>
            </ul>
          </aside>
          <article>
            <nav>
              <img src="../img/sub_nav_tit_cate1_tit2.png" alt="찾아오시는길"/>
              <p>
                HOME > 팜스토리소개 > <span>찾아오시는길</span>
              </p>
            </nav>
            <!-- 컨텐츠 내용 시작 -->
            <!-- * 카카오맵 - 지도퍼가기 -->
            <!-- 1. 지도 노드 -->
            <div id="daumRoughmapContainer1558595254586" class="root_daum_roughmap root_daum_roughmap_landing"></div>

            <!--
            	2. 설치 스크립트
            	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
            -->
            <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

            <!-- 3. 실행 스크립트 -->
            <script charset="UTF-8">
            	new daum.roughmap.Lander({
            		"timestamp" : "1558595254586",
            		"key" : "tmh8",
            		"mapWidth" : "760",
            		"mapHeight" : "400"
            	}).render();
            </script>


            <!-- 컨텐츠 내용 끝 -->
          </article>
        </section>
      </section>
      <footer>
        <img src="../img/footer_logo.png" alt="로고"/>
        <p>
          (주)더조은 / 사업자번호 123-45-67890 / 통신판매신고 제 2013호 / 등록번호 더조은1234 / 발행인 : 홍길동<br>
          대표자 :	홍길동 / 개인정보관리자 : 홍길동 / ☎ 051) 123-4567 / 부산광역시 부산진구 부전동 123 5층<br>
          <span>Copyright ⓒ(주)더조은 All rights reserved.</span>
        </p>
      </footer>
    </div>

  </body>
</html>
