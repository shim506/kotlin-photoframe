README.md 파일을 자신의 프로젝트에 대한 설명으로 변경한다. 단계별로 미션을 해결하고 리뷰를 받고나면 README.md 파일에 주요 작업 내용(바뀐 화면 이미지, 핵심 기능
설명)과 완성 날짜시간을 기록한다. 실행한 화면을 캡처해서 README.md 파일에 포함한다.

# Step2

<br></br>

## 코드로 ConstraintLayout에 View 배치하기

```
제시된 빈칸을 체운 부분은 아래와 같이 배치되어있습니다.
step 1. asset 폴더에서 파일 열기 
MyImage class 내부에서 실행

step 2. imageView에 표시
imageChange 함수에 구현
```
<br></br>
![img_5.png](img_5.png)
![img_6.png](img_6.png)

<br></br>

## 갤러리에서 사진 선택하기

1. Intent.ACTION_GET_CONTENT 형식의 Intent 를 뿌린다.
2. Intent 를 받고 이미지 주소를 돌려준다.
3. Glide 를 통해서 해당 주소에서 이미지를 가져온다.
   <br></br>
![img_7.png](img_7.png)

<br></br>

# 추가 학습사항

## Activity

학습중..
<br></br>

## Intent

학습중..
<br></br>

## 프록시 패턴

프록시는 "대신" 이라는 의미로 프록시 패턴은 어떤 리소스를 직접 접근하지 않고 중간에 프록시 객체가 대신 응답해주는 방식을 말한다 이를 통해 리소스의 실질적 정보를 필요로하는
순간까지 로딩을 미룰 수 있다.

프록시 패턴을 통해 지연 로딩 후 캐시로 로딩한 파일을 가지고 있을 수 있다.

- (장점)즉시 로딩보다 메모리 사용량이 적음
- 비교적 최신 데이터를 로딩할 수 없음
- 실행시 병목점을 찾거나 클라이언트가 로딩 시점을 알 수없음
  <br></br>

## 옵저버 패턴 및 리스너

수신자 객체에서 발신자 객체로부터 event를 수신받기 위해서는 둘사이를 이어주는 Interface 를 이용할 수 있다.

### 1. 둘사이를 이어줄 인터페이스(이하 리스너)

```
interface EventListener {
    fun onEvent(count: Int)
}
```

### 2. 발신자 객체

    - 발신자는 인자로서 리스너를 받는다.
    - 특정 이벤트 발생시 리스너의 함수를 실행한다.

### 3. 수신자 객체

- 리스너를 상속받아 리스너의 함수를 구현한다.

```

class EventPrinter : EventListener {
    override fun onEvent(count: Int) {
        print("${count}-")
    }
}
```

### 동작 원리

- 발신자 객체에서 이벤트가 발생하면 생성시 인자로 넣은 인터페이스 함수를 실행한다.
- 컴파일시 연결된 인터페이스 함수의 구현체로 이동하여(수신자) 원하는 동작을 실행하다.  
  <br></br>

## ViewBinding

- findViewById 를 대체하여 사용할 수 있음
- viewBinding은 gradle에 설정을통해 개발자가 작성한 레이아웃 파일들을 공식에 맞게 모두 바인딩클래스로 자동변환 해줍니다.
- 자동변환공식 : 레이아웃파일명(첫 글자와 언더바 다음영문을 대문자로 변환) + Binding
- ex) activity_main.xml = ActivityMainBinding
  <br></br>

## Glide 라이브러리

- 이미지 주소를 통해서 간단히 이미지 로딩을 할 수 있다.
- 이미지 처리에 대한 다양한 함수를 제공하낟.
- 캐시 기능을 가지고 있어서 이미지를 빠르게 처리할 수 있다.