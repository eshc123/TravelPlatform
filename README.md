<h1 align="center">Travel Platform : Busan Travel</h1>  

<p align="center">  
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>  
</p>  

<p align="center">  
<img src="https://user-images.githubusercontent.com/50227341/171097430-c06a6a1e-8592-4c1d-ba11-04533668b12e.png" width="75%" />  
</p>  



##### Framework & Libraries

1. [Android Architecture Components](https://developer.android.com/jetpack/guide)
2. [Room](https://developer.android.com/training/data-storage/room )
3. [Coroutine](https://developer.android.com/kotlin/coroutines)



##### Clean Architecture 

- Domain, Data, Presentation(UI)로 분리

  - ~~패키지단위로 분리, 모듈화 공부 후 모듈화 적용~~ -> 모듈화 적용

- Domain

  - Model, Repository, Usecase
    - Model은 Domain 단계에서 쓰일 데이터 모델
    - Repository는 interface로, 구현은 Data 단계에서

- Data

  - Local, Remote, Repository

    - Local은 Room을 활용한 내부 DB와 DataSource로 구성

    - Remote는 네트워크 통신

    - Repository는 Domain의 Repository 인터페이스를 구현

      *백엔드 개발 중단으로 인해 Remote는 쓰이지 않고 모든 데이터를 Local에서 하는 것으로 대체*

- Presentation(UI) 
  - MVVM 구조 따르고자 함
  - 프로젝트 내 app

##### Room



##### Coroutine


Project : https://github.com/eshc123/TravelPlatform/projects/1
