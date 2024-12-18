# Git, Github

## 📚 오늘 배운 내용

### 😀 시작하기

Git 학습 사이트: [backlog](https://backlog.com/ja/git-tutorial/)

### 😀 Repository
- Local Repository<br/>
> 현재 내가 사용하고 있는 내 디바이스(PC) 에 저장되는 저장소 
- Remote Repository
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
```bash
git --version 
git version 2.45.2
```
### 😀 글로벌 설정
- 최초 한번만 설정
- 코드 기록시 표시될 내용 
```bash
git config --global user.name "JaeYoun Kim"
git config --global user.email "rlawodusx@naver.com" 
```

### 😀 현재 디렉토리를 로컬 저장소 만들기
- 기본적으로 하나의 브랜치가 생성됨(main 또는 master)
```bash
git init
```
### 😀 브랜치란?
- git branch 명령으로 확인 가능
- main or master 설문 확인 
> 독립적으로 어떤 작업을 진행하기 위한 개념 
>> 필요에 의해 만들어지는 각각의 브랜치는 다른 브랜치의 영향을 받지 않기 때문에, 여러 작업을 동시에 진행이 가능

### 😀 Git 브랜치 병합 전략
브랜치 병합 전략은 3가지
```markdown
1. Merge
2. Rebase
3. Squash
```

1. Merge   
Merge에는 여러가지 방식이 있지만 크게 두 가지 방식이 존재 
```markdown
Fast-Forward
3-Way-Merge
```

- Fast-Forward
> Master 브랜치에서 생성된 A 브랜치를 Merge 할 경우 조상 브랜치인 Master에 변경점이 없다면 Master 브랜치를 바로 A로 브랜치로 이동해서 Merge하는 것

- 3-Way-Merge
> Fast-Forward랑 다르게 아래처럼 A 브랜치와 Master 브랜치 둘다 변경사항이 있을 경우에 Merge 하는 경우   
정리하면, 각 브랜치의 최신 Commit과 공통 Base 커밋을 비교하여 새로운 Commit을 만들어 Merge 하는 전략 

그렇다면, Merge의 특징은?
> - 변경 내용의 커밋 내역이 모두 그대로 유지   
> - Merge시 Merge Commit이 새로 생성    
> 그렇기 때문에, 불필요한 Commit 내역이 생겨 history가 지저분해져서 협업 과정에서 Commit 확인에 대한 불편함이 발생 


2. Rebase
> - 공통 base를 가진 두 브랜치에서 하나의 브랜치의 base를 다른 브랜치의 최신 Commit을 base로 하게 끔 재정렬 하는 것   
>
> Rebase를 수행할 경우 Merge와 다르게 Merge Commit이 생기지 않음. 따라서, 하나의 브랜치에서 작업한 것처럼 보이기 때문에 히스토리를 간결하게 할때 사용

하지만, 지저분한 Commit의 해결방법? 답은 Squash!!

3. Squash
> Git Squash는 여러개의 Commit을 하나의 Commit으로 만들어줌

Squash를 하려면 우선 Rebase에 -i 옵션을 이용
```bash
git rebase -i [CommitID]
```
입력 했으면, Commit Hash 다음 Commit 내역들이 표시   
그리고, 'Squash' CommitID를 입력, 다음은 예시 코드
```bash
git rebase -i 57d3f1b
```

그리고 Squash의 옵션중 Pick 옵션을 주고 합쳐질 Commit에 squash를 입력 -> 저장 -> 새로운 창에서 Commit Message를 입력하게 되면 커밋 내역이 합쳐짐.   
결론적으로는, Pick과 squash를 사용하면 하나의 커밋이 아닌 원하는 커밋 수로 압축 

이밖에 다른 옵션들
- reword   
> 단순히 Commit Message 변경 

- fixup
> squash와 기능은 동일 하나 커밋 메시지를 새로 쓸 수 없고 pick한 부분의 커밋 메시지로 합쳐짐 

- drop
> 해당 커밋 제거, 해당 커밋에서 변경된 작업도 원래대로 돌아감 
### 😀 작업 트리 상태 확인(git status)
- git status 명령으로 현재 추적(Untracked)되지 않는 파일을 확인 가능 
```bash
git status
```
### 😀 기록할 파일 추적을 위한 인덱싱 등록(git add)
- 다음과 같은 여러가지 방법이 존재
```bash
git add <파일명>
```
```bash
# 와일드 카드 사용가능
git add *.txt
```
```bash
# 모든 파일 추가 가능
git add .
```

### 😀 gitignore 설정
- 불필요한 파일은 gitignore에 추가하여 버전 관리에서 제외 
- 예시
```markdown
# IDE 설정 파일
.idea/
.vscode/

# 빌드 결과물
build/
dist/

# 의존성 디렉토리
node_modules/
vendor/

# 로그 파일
*.log
```
### 😀 변경 사항을 기록(commit)
```bash
git commit -m "커밋 메시지"
```

### 😀 수정, 기록 반복..
```bash
# 1. 파일 수정

# 2. indexing

# 3. 커밋
git commit -m "xx기능을 추가"
```


### 😀 가이드에 나오는 명령어 이해하고 골라 쓰기
```bash
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
```bash
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
```bash
git log
```

### 😀 github에 최초 표시
```bash
git remote add origin <업로드할 git 주소>
git push -u origin main
```
