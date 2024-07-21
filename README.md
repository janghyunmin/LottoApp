
# :technologist: Lotto #토이 프로젝트

<p><a href="https://www.figma.com/design/pzVSNSQWwgPEvYIk9QByXZ/%EB%9D%BC%EC%9D%B4%EC%96%B8's-team-library?node-id=0-1&t=YNbuUIIrf32qoNms-0">Figma 링크</a>
</p>

> 로또 번호 조회와 함께 나만의 1등 번호를 만들어 보세요.

<!-- ![](https://user-images.githubusercontent.com/38487811/90950455-85d36700-e48c-11ea-9b79-72b5dcb6c6d6.png) -->

(↑프로젝트를 대표하는 대표 이미지)


## 📖 Description

매주 로또 당첨 번호를 앱에서 조회하여 결과를 확인하면 어떨까?

로또 당첨 번호를 내가 만들어보면 어떨까?

내 주변 로또 판매점은 어딜까? 

이러한 궁금증을 돕기 위하여 어플리케이션을 만들었습니다.


<!-- ## :baby_chick: Demo
(↑해당 프로젝트가 실제 배포되고 있지 않아서, 이미지로 프로젝트의 뷰를 대체할 경우)
 <p float="left">
    <img src="https://lh3.googleusercontent.com/iYHEwh2_Q6nIKS67eItV4AwIokeJDNe0ojtpWGqKpRyhaRlmCSmBcnkFNCmXbTkajKA=w2560-h1330-rw" width=200 />
    <img src="https://lh3.googleusercontent.com/xl0sqT6Jz1p9Gq9slw4VXRr-akf4v74b_k3QkZUMZPvYV37-e5LqTZcOjofof4Xyl48=w2560-h1330-rw" width=200 />
    <img src="https://lh3.googleusercontent.com/JqUUXWSgU0bhSBpOObERLvfUGE3eBnInmYvDMY3S2aAatyeFKLOifWnBLgZ0KLGbmA=w2560-h1330-rw" width=200 />
    <img src="https://lh3.googleusercontent.com/AdN5fkguQMSc4M6iVkAFONsuxZhOQaKE7TDzuhF56FgDLORAnBv8160W7vva4a6kFBg=w2560-h1330-rw" width=200 />
    <img src="https://lh3.googleusercontent.com/ruDvvtKehqGB_4PX7QBsUY2RLDe_v6g5FL-_XmC6SUGjKUQqa08Uy-DtsNi8wYuuXU4=w2560-h1330-rw" width=200 />
</p> -->

## ⭐ Main Feature
### 매주 로또 번호 조회
- [매주 당첨 번호 조회를 통하여 데이터를 가져올수있다.]<br>(https://dhlottery.co.kr/gameResult.do?method=byWin)

### QR 당첨 확인 기능
- QR 코드를 통하여 로또 용지를 스캔하여 당첨 조회를 할 수 있다.

### 주변 판매점 확인하기
- 나의 위치를 중점으로 주변에 로또 판매점을 확인 할 수 있다.

### 분석하기
- 핫수,콜드수,짝수,홀수 등 1회차 ~ 현재 N 회차 까지의 번호를 분석하여 확률을 높일 수 있는 번호를 조합 할 수 있다.

### 내가 만든 번호 확인하기
- 내가 만든 커스텀 번호를 확인 할 수 있다.

### 번호 만들기
- 자동 , 수동 으로 나만의 번호를 만들어 저장 할 수 있다.

## 🔧 Stack
- **Language**: Kotlin , Compose , Python
- **Framework** : Android Studio , Figma
- **Database** : Firebase DataBase
- **CI/CD**: Fastlane, GitHub Actions

## :open_file_folder: Project Structure

```markdown
src
├── presentation
│   ├── main
│   ├── feature
│       ├── viewModel
│       ├── Activity
│       ├── Fragment
│   └── ui.theme
│       ├── type
│       ├── theme
│       ├── colors
│       └── shape
│   └── App
├── buildSrc
├── data
│   ├── api
│   ├── entity
│   ├── mapper
│   ├── module
│   ├── repository
│         ├── local
│               ├── dataSource
│               ├── dataSourceImpl
│         ├── remote
│               ├── remoteSource
│               ├── remoteSourceImpl
│       ├── repositoryImpl
│   ├── utils
├── domain
│   ├── dto
│   ├── repository
│   └── usecase

```

<!-- ## 🔨 Server Architecture
(↑서버 아키텍처에 대한 내용을 그림으로 표현함으로써 인프라를 어떻게 구축했는 지 한 눈에 보여줄 수 있다.)
![](https://docs.aws.amazon.com/gamelift/latest/developerguide/images/realtime-whatis-architecture-vsd.png) -->

## ⚒ CI/CD
- github actions를 활용해서 지속적 통합 및 배포
- `feature` 브랜치에서 `dev`로 Pull Request를 보내면, CI가 동작된다.
- `dev`에서 `master`로 Pull Request를 보내면, CI가 동작되고 Merge가 되면, 운영 리소스에 배포된다.

**Devops**

- CI/CD 구축 (Github Action)

**etc**

- 전체 개발 일정 및 이슈 관리
