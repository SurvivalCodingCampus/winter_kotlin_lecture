# git 기초

## git의 개념과 학습 이유

### VCS?
**Version Control System**

수정한 파일을 매번 저장한다면 메모리에 차지하는 용량이 점점 커진다.

- 변경사항만 저장할 수 있다면 좋을텐데?

  *-> 버전 관리를 하자 !*

>git 가이드북
>https://git-scm.com/book/ko/v2


- 기술 생산자와 기술 활용자가 같지 않은 시대.
  오픈소스 활용시 모든 것을 바닥부터 만들지 않아도 된다.

  *-> Open Source를 누리자!*


## git 설정 방법
```
$ cd ~
$ mkdir git-basic
$ cd git-basic

$ git init
$ git commit # => 안내문 나옴
$ git config --global user.email "개발에쓸@이메일"
$ git config --global user.name "내이름"
```

## git 버전 관리 시작하기

1. 폴더/dir

2. `$ git init` -> 버전 관리 시작-> .git/

   해당 폴더가 Repository로 진화됨

3. `$ rm -r .git/` -> 버전 전부 삭제 -> .git/삭제

   해당 Repository가 폴더로 됨

## git의 흐름 이해

>git의 흐름을 광고촬영장으로 비유하여 시각화 해보자

### 1.Working Directory
(분장실)

a.txt

b.txt


* `$ git add c.txt` Stage에 올림

* `$ git add .` 현재 디렉토리 기준 변경사항 있는 것만 한번에 스테이징


### 2.Stage
(무대)
* `$ git restore --staged c.txt` Stage에서 내림

* `$ git commit -m '찰칵'` Stage에 있는 것을 Commit. 사진 찰칵

스테이징된 변경 사항 : add한 것

변경 사항 : add 이후에 또 변경한 것

### 3.Commits
(사진첩)

* `$ git restore c.txt` 사진첩에 올라간 사진 기준으로 복구

* `$ git status` 현재 상태 브리핑

* `$ git log` 커밋들(사진첩) 상태 보기

* `$ git log --oneline` git 히스토리 짧게 보기

* `q` : $(prompt)로 돌아가기


```
$ touch a.txt
$ git add a.txt
$ rm a.txt
$ git restore a.txt
$ git add a.txt => git commit -m 'add msg'
```
---
# git remote

## WARNING! 주의사항
1. master 위치, 현재 위치를 잘 확인한다
2. Repo 안에서 또 다른 repo(master)를 만들지 않는다.

   이미 git init을 한 곳 안에

   하위 폴더를 만들고

   그 하위 폴더에서 git init을 하지 않는다.

   master가 떠 있으면 init을 제발 하지 않는다.

3. Home(~)에서 init하지 않는다.
   repo 밖에서 repo를 만들지 않는다.
4. (지금은)github에서 직접 수정하지 않는다. 드라이브에서 폴더, 파일 직접 수정할 수 있지만 지금은 하지 않는다.


## Recommendations 권장사항
1. 커밋 메시지는 짧지만 내용은 담아서
2. 모든 Repo(프로젝트)는
    - README.md
    - .gitignore를 담고 있도록 한다.

      `$ touch .gitignore`

   .gitignore 안에 공유되어선 안 될 것들의 목록을 적음

프로젝트에 맞는 .gitignore 파일 생성하기 위한 URL
> https://www.toptal.com/developers/gitignore/

---
## 프로젝트 초기화 진행
​
### 계정 세팅
​
```sh
# (계정당 1회) 서명이 등록되지 않았다면, 계정용 서명 등록
$ git config --global user.name '내이름'
$ git config --global user.email 'github에서@쓸메일주소'
# 서명이 정상적으로 등록되었는지 확인
$ cat ~/.gitconfig  
```
​
### 프로젝트 생성부터 push까지
​
```sh
# 프로젝트 폴더 생성
$ mkdir new_project
​
# 프로젝트 폴더로 이동
$ cd new_project
​
# README 파일 & .gitignore 생성
$ touch README.md .gitignore
​
# gitignore.io 에 접속하여 필요한 내용 복-붙
​
# 폴더를 리포로 초기화
$ git init
​
# README & .gitignore 파일 add(tracking)
$ git add .
​
# commit
$ git commit -m 'first commit'
​
# github에서 원격 저장소 직접 생성
​
# 생성한 원격 저장소 등록  (origin 은 별칭)
$ git remote add origin <URL>
​
# 등록된 저장소 확인
$ git remote -v
​
# 지금까지의 commit들 모아서 push
$ git push origin master
```
---
​
## 명령어 정리
​1. 리포 초기화 시점에 1회 입력
​
```sh
$ git init 
```
​
2. 작업 후 스테이징
   ​
```sh
# 특정 파일만 add 할 때
$ git add <filename>
# 현재 폴더 내 수정된 파일 전체를 add 할 때
$ git add .
```
​
3. 커밋 진행
   ​
```sh
# 메시지는 짧고 정확하게
$ git commit -m 'MESSAGE'
```
​
​
4. 모니터링 명령어
   ​
```sh
# 현재 Working Dir 과 Stage 상황 확인 (주기적으로 확인하자!)
$ git status
​
# commit 로그 
$ git log     
# commit 로그 짧게
$ git log --oneline
```
​
5. github 에 원격 저장소 생성하기 (github site에서 `New Repository`)

   6.원격 저장소(remote repo) 추가하기
   ​
```sh
$ git remote add origin <URL>
```
​
7. 원격 저장소 확인하기
   ​
```sh
$ git remote -v
```
​
8. 원격 저장소에 지금까지의 commit 들 PUSH 하기
   ​
```sh
$ git push origin master
```
​
9. 새로운 컴퓨터에서 기존 원격 저장소 복제하기
```sh
$ git clone <URL>
```
​
10. 원격 저장소의 내용 받아오기
```sh
$ git pull origin master
```
​
|상황|명령어|
|--|--|
|집에서 새로운 프로젝트 시작|`$ mkdir project`|
|프로젝트 폴더로 이동|`$ cd project`|
|리포 초기화|`$ git init`|
|README, .gitignore 생성|`$ touch README.md .gitignore`|
|파일 스테이징|`$ git add .`|
|커밋|`$ git commit -m 'first commit'`|
|원격저장소 생성|github 사이트에서 진행|
|원격 저장소 등록|`$ git remote add origin <URL>`|
|원격 저장소 PUSH|`$ git push origin master`|
|다른 컴퓨터에서 원격저장소 복제|`$ git clone <URL>`|
|작업|`add`, `commit`|
|귀가 직전|`$ git push origin master`|
|집 도착 이후|`$ git pull origin master`|
|작업|`add`, `commit`|
|작업 종료|`$ git push origin master`|
|다른 컴퓨터에서 반복|`$ git pull origin master`|

---
# Github 설정

1. Settings - Repositories - main을 master로 바꿔주기

   (BLM[Black Lives Matter] 조지플로이드 흑인과잉진압 사건때문에 깃허브에서 master라는 이름이 불편해 main으로 바뀌게 되었다.)

2. New Repository 생성

   내 컴퓨터 상의 Local Repository name과 깃허브의 Repository name은 꼭 같지 않아도 됨

3. Local Repo와 깃허브 Repo 연결하기

   `git remote add origin https://github.com/choe-yujin/TIL.git`

   = git님 remote원격저장소를 add추가할게요. (origin은 깃허브 repo 주소의 별명)깃허브 repo주소값에.

   `git remote add`는 고정되는 명령어. 뒤에 별칭과 주소는 바뀔 수 있다.

4. 동기화

   자동 동기화는 안 됨.

   `git push origin master` 내 local Repo를 깃허브에 올린다는 명령어

   = git님 push올릴게요. origin이라고 별칭 붙인 깃허브 repo 주소값에.



