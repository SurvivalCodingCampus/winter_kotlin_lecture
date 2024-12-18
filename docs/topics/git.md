### 일일 학습 기록 (상세)
```markdown
# 2024-12-16 ~ 2024-12-17

## 📚 오늘 배운 내용
- git 설치 후 초기설정 필요

- push 업로드
- pull 내려받기
- clone 복사

- branch > 가지/분기
- 기본 branch => master

- git status 브랜치 상태 확인
- git add 관리/추적(스테이징)할 파일 추가

- .gitignore > 관리하지 않을 부분들 지정

- origin > remote 레포지터리의 master라고 생각

- psuh하는 과정
  add > commit > push

- 스샷은 github에서 직접 edit이 편함(단 pull해줘야 내 local에 반영됨)
- reset은 반드시 push한 후에 사용해야 함 안그럼 코드 날아감

- reset > mixed : 코드는 유지됨
- reset > hard : commit 안해놓으면 거기까지 날아감

- 하던 작업들을 왔다 갔다 하기 위해서 로컬에서 브랜치 사용

- git checkout 브랜치명     : 브랜치 변경
- git checkout -b 브랜치명  : 브랜치 변경(없으면 생성해서)
- git fetch                : 리모트에서 변경사항을 가져오지 않고 알려만 줌
- git merge 브랜치명        : 현재 위치한 브랜치에 해당 브랜치 가져와 병합
- git rebase 브랜치명       : 현재 위치한 브랜치에 해당 브랜치를 베이스로 가져옴



## 💻 예제 코드
- git config --global user.name "Git 이름"
- git config --global user.email 이메일주소
- git init
- git status
- git add .
- git commit -m "커밋할게요"
- git push -u origin master
- git pull origin master
- git branch
- git branch issue1
- git checkout master
- git checkout -b issue2
  git checkout -D issue1
- git merge issue1
- git rebase issue2

```