# Git, Github

## 📚 오늘 배운 내용

### 😀 시작하기

Git 학습 사이트: [backlog](https://backlog.com/ja/git-tutorial/)

### 😀 Repository
- RemoteRepository<br/>
> 현재 내가 사용하고 있는 내 디바이스(PC) 에 저장되는 저장소 
- Local Repository
> Git의 주 목적은 파일 공유, 원격 저장소는 원격 서버에 저장되고 관리되는 저장소


### 😀 Git 설치 
Git 설치 주소: [Git Install](https://git-scm.com/)

- Mac 사용자는 기본 Apple Git 설치 되어 있음 
- HomeBrew를 통해 공식 Git을 설치할 수 있음
- Windows 사용자는 winget을 통해 Git 설치도 가능 
### 😀 필수 Git 명령어
- git init
- git add
- git status
- git log
- git commit
- git clone
- git pull
- git push

### 😀 Git 버전 확인
- Window는 git-bash에서 리눅스, Mac은 터미널에서
```
git --version 
git version 2.45.2
```
### 😀 글로벌 설정
- 최초 한번만 설정
- 코드 기록시 표시될 내용 
```
git config --global user.name "JaeYoun Kim"
git config --global user.email "rlawodusx@naver.com" 
```

### 😀 현재 디렉토리를 로컬 저장소 만들기
- 기본적으로 하나의 브랜치가 생성됨(main 또는 master)
```
git init
```

### 😀 브랜치란?
- git branch 명령으로 확인 가능
- main or master 설문 확인 
> 독립적으로 어떤 작업을 진행하기 위한 개념 
>> 필요에 의해 만들어지는 각각의 브랜치는 다른 브랜치의 영향을 받지 않기 때문에, 여러 작업을 동시에 진행이 가능

### 😀 작업 트리 상태 확인(git status)
- git status 명령으로 현재 추적(Untracked)되지 않는 파일을 확인 가능 
```
git status
```
### 😀 기록할 파일 추적을 위한 인덱싱 등록(git add)
- 다음과 같은 여러가지 방법이 존재
```
git add <파일명>
```
```
# 와일드 카드 사용가능
git add *.txt
```
```
# 모든 파일 추가 가능
git add .
```

### 😀 gitignore 설정
- 불필요한 파일은 gitignore에 추가하여 버전 관리에서 제외 

### 😀 변경 사항을 기록(commit)
```
git commit -m "커밋 메시지"
```

### 😀 수정, 기록 반복..
```
# 1. 파일 수정

# 2. indexing

# 3. 커밋
git commit -m "xx기능을 추가"
```


### 😀 가이드에 나오는 명령어 이해하고 골라 쓰기
```
# README.md 라는 파일 생성하는 리눅스 명령어
echo "# git_tutorial" >> README.md

git init
git add README.md
git commit -m "first commit"

# 브랜치 이름 main으로 변경(예전에는 master가 기본이었음)
git branch -M main

# 로컬 저장소를 리모트 저장소에 origin 이라는 별칭으로 연결
git remote add origin <git 주소>

# 로컬의 origin을 리모트의 main 브랜치에 업로드 
git push -u origin main
```

### 😀 반복
```
# 수정 -> 등록 -> 커밋 -> 푸시(반복)
git add .
git commit -m "수정사항"
git push
```


### 😀 커밋 컨벤션
> 일관적인 커밋 메시지를 작성하는 것이 좋다.
- feat: 새로운 기능 추가 
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅
- refactor: 코드 리팩토링
- test: 테스트 코드 추가 또는 수정
- chore: 빌드 업무 수정, 패키지 매니저 수정
- design: CSS 등 사용자 UI 디자인 변경
- comment: 필요한 주석 추가 및 변경
- rename: 파일 혹은 폴더명을 수정하거나 옮기는 작업
- remove: 파일을 삭제하는 작업만 수행한 경우
- !BREAKING CHANGE: 커다란 API 변경의 경우
- !HOTFIX: 급하게 치명적인 버그를 고쳐야 하는 경우 

### 😀 커밋 로그 표시
```
git log
```

### 😀 github에 최초 표시
```
git remote add origin <업로드할 git 주소>
git push -u origin main
```
