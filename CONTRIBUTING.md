### contributing with source codes

1. [Director](https://github.com/bnbong/bnbong.github.io)에게 연락하여 firebase의 Awesome_ChattingApp의 접근 권한을 얻습니다.
2. 작업 환경은 Android Studio 3.6.3, JAVA version 12로 설정합니다.
3. 다음과 같은 명령어를 작성하여 Awesome_ChattingApp의 레포지토리에 있는 모든 소스코드를 다운 받고, 자신의 브랜치를 생성합니다. 이때, 브랜치 명은 자신의 Github 닉네임으로 작성합니다.

```
git clone git@github.com:bnbong/Awesome_ChattingApp.git

git branch [contributor's github nickname]

git checkout [contributor's github nickname]

git push --set-upstream origin [contributor's github nickname]
```

4. 소스코드와 관련된 작업을 마친 뒤, 작업물을 본 레포지토리에 업로드하는 방법은 다음과 같습니다.

```
git status

git add .../newfile.java

git commit -m "write your works"

git push origin [contributor's github nickname]
```


**주의사항**
*   본 프로젝트에서 요구하는 코딩스타일은 없으나, 자신의 소스코드의 클래스 앞에 이 클래스가 무엇을 위한 클래스인지 주석으로 한줄정도 요약해주시면 감사하겠습니다.
*   버그 픽스등의 source code contributing은 별다른 허가 없이 수정하는 것이 가능합니다. 다만, 새로운 서비스를 추가할 때에는 무조건 디렉터에게 알린 후 허락을 맡고 작업하셔야 합니다.

### contributing with documentation

1. 다음과 같은 명령어를 작성하여 Awesome_ChattingApp의 레포지토리에 있는 모든 소스코드를 다운 받고, 자신의 브랜치를 생성합니다. 이때, 브랜치 명은 자신의 Github 닉네임으로 작성합니다.

```
git clone git@github.com:bnbong/Awesome_ChattingApp.git

git branch [contributor's github nickname]

git checkout [contributor's github nickname]

git push --set-upstream origin [contributor's github nickname]
```

2. 문서화와 관련된 작업을 마친 뒤, 작업물을 본 레포지토리에 업로드하는 방법은 다음과 같습니다.

```
git status

git add .../newfile.md

git commit -m "write your works"

git push origin [contributor's github nickname]
```


**주의사항**
*   README.md파일은 **절대**수정하지 마세요!!!
*   새로운 문서화 작업물은 모두 /docs 폴더에 저장해주세요
