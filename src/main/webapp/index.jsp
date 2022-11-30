<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <main role="main">

        <section class="jumbotron text-center">
          <div class="container">
            <h1 class="jumbotron-heading">Fitness Potential에 방문하신 여러분들을 환영합니다.</h1>
            <p class="lead text-muted">
                Fitness Potential에서는 운동 및 식단 관리와 더불어 다른 사용자와의 의사소통을 위한 게시판을 이용하실 수 있습니다.
            </p>
            <p>
                <br>
                <br>
            </p>
          </div>
        </section>
  
        <div class="album py-5 bg-light">
          <div class="container">
  
            <div class="row">
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">게시판</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        다른 사용자와 경험을 공유하고 싶으신가요?
                        여러분들의 운동 루틴과 경험을 공유하거나 의견을 나눌 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/community'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">운동기구정보</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        운동 기구를 어떻게 사용하는지 알 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/fitness/info'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">운동루틴</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        운동 루틴을 짜거나 운동 시작할 때 사용할 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/fitness/routine'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
  
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">운동일지</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        여러분들이 매일매일 어떤 운동을 했는지 기록할 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/fitness/diary'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">음식정보</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        평소에 먹는 음식에 칼로리, 탄수화물, 단백질, 지방 등의 영양정보를 알 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/food/info'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <h5 class="card-title">식단일지</h5>
                      <h6 class="card-subtitle mb-2 text-muted"></h6>
                      <p class="card-text">
                        여러분들이 매일매일 시간별로 어떤 음식을 먹었는지 기록할 수 있습니다.
                      </p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='/food/diary'">바로가기</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </div>
  
            </div>
          </div>
        </div>
      </main>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>