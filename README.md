# 애드팝콘 오퍼월
애드팝콘 오퍼월 서비스는 앱 안에 오퍼월(충전소)을 노출시키고 유저 광고 완료 수에 따라서 개발사에 수익금을 드리는 수익화 서비스입니다.

(클라이언트 타입: IGAW 리워드서버에서 전달하는 콜백을 수신할 자체서버 구축이 어려운 경우에 추가 클라이언트 연동을 통해서 리워드 지급을 처리)

# Igaworks Sample 불러오기
### 방법 1
1. Click **"Download ZIP"** button
1. Unzip files
1. Open Android Studio
1. File > Open...
1. Click download folder

### 방법 2
1. Copy **"HTTPS clone URL"**
1. Open Android Studio
1. VCS > Checkout from Version Control > Git
1. Paste to Vcs Repository URL, Clone

# Adpopcorn Offerwall Sample (Client Type) 실행
1. IGAW 홈페이지에서 발급받은 **앱키, 해시키**를 AndroidManifest.xml 파일에 입력
1. 수익화 > adPOPcorn Offerwall > OfferWall 관리 메뉴로 이동 (_설정을 모두 진행해야 테스트 광고 노출_)
  * 기본 설정
    - 기본설정 > 연동방식 SDK 선택
    - 가상화폐 설정 > 이름, 전환비율 설정
  * 코드연동
    - 리워드 지급 설정 > IGAWorks 서버 선택
  * 검수 및 최적화
    - 테스트 디바이스 등록 후 설정
1. 실행

# Igaworks Adpopcorn Offerwall 연동하기
연동 가이드와 샘플 프로젝트를 참고하여 연동을 진행합니다. </br>
<a href="http://help.igaworks.com/hc/ko/3_3/Content/Article/adpopcorn_offerwall_aos" target="_blank">Igaworks Adpopcorn Offerwall 연동문서 바로가기</a>

애드팝콘 오퍼월 서비스는 리워드 지급 처리가 필요합니다.</br> 
클라이언트 타입의 리워드 연동은 다음문서를 참고하여 진행합니다.</br>
<a href="http://help.igaworks.com/hc/ko/3_3/Content/Article/adpopcorn_offerwall_client_reward_aos" target="_blank">Client Rward 연동문서 바로가기</a>
