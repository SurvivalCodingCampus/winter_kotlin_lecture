# git 명령어 정리
## add
git add : 코드의 변경사항을 staging area에 등록한다
git add *.txt : 와일드 카드 사용 가능
-p : hunk별로 추가

## commit
git commit : repository로 저장
-m (커밋 메시지) : 해당 커밋 메시지로 저장
-am (커밋 메시지) : add하지 않고 저장. 단, file이 한 번이라도 add된 적 있어야 한다
--amend : 커밋 메시지 수정(에디터)
--amend -m (커밋 메시지) : 해당 메시지로 수정
-v : 에디터에서 diff를 보여주고, 해당 에디터에서 메시지를 입력 후 커밋할 수 있다

## switch
git switch (branch명) : 해당 branch로 이동
-c (branch명) : branch를 생성 후 이동
-t origin/(branch명) : 원격의 branch를 로컬에 같은 이름으로 생성하여 연결하고 이동

## checkout
git checkout (커밋해시) : 해당 커밋으로 이동한다
📌 checkout을 통해 branch의 이동도 가능하지만, switch가 생긴 이후로는 switch를 사용해서 이동하도록 하자

## branch
git branch : 생성된 branch 확인
(이름) : 해당 이름으로 branch 생성
-m (현재이름) (바뀔이름) : branch 이름 변경
-d (이름) : 해당 branch 삭제

## merge
git merge (branch명) : 현재 branch에서 해당 branch를 merge, 충돌이 없을 경우 커밋 생성
--abort : 만약 충돌이 발생해서 수정하는 도중 merge를 취소할 때 사용하면 다시 되돌아간다
--no-ff (branch명) : fastforward 방식이 아닌 merge
--squash (branch명) : 두 개의 브랜치를 병합하는데, 병합되는 커밋들을 하나의 커밋으로 압축(squash)하여 새로운 커밋으로 만드는 옵션

## rebase
git rebase (이어 붙일 branch명) : 현재 branch에 이어 붙인다 후에 merge를 진행하여 두 branch의 단계를 맞춰준다
--abort : 만약 충돌 발생시 rebase를 취소
--continue : 만약 충돌 과정이 하나가 아니라 여러개일 경우 앞에 해결한 충돌은 add를 통해 더해주고 --continue 명령어를 사용하여 현재 변경 사항을 커밋하고 다음 충돌을 진행시킨다(만약 충돌해결 과정중 rebase가 필요 없게 된다면 커밋이 추가되지 않는다)

📌이전의 커밋들을 수정하기
git rebase -i (커밋해시) : 커밋해시 이후의 커밋 리스트를 불어와서 해당 명령어를 이동하여 수정할 수 있다

|명령어|설명|
|---|---|
|p, pick|수정 x(default)|
|r, reword|메시지 변경|
|e, edit|코드 수정|
|d, drop|커밋 삭제|
|s, squash|커밋 압축|

## push
git push : 원격 저장소의 최신 커밋을 로컬로 가져와 merge 또는 rebase
--force : 강제 push
-u origin (branch명) : 원격 저장소에 해당 branch가 없다면 생성 후 push
origin --delete (branch명) : 원격의 branch 삭제

## pull
git pull : 원격저장소의 내용을 가져온다
--no-rebase : merge 방식
--rebase : rebase 방식

## fetch
git fetch : 원격 저장소의 최신 커밋을 로컬로 가져오기만 함
git checkout origin/(branch명) 명령어를 통해 해당 원격의 변경사항을 확인해보고,
pull을 받는 용도로 사용한다

## reset
git reset : reset한 이후의 커밋이 히스토리에서 지워진다
--hard : 완전히 삭제
--mixed : repository에서 working directory로 이동
--soft : staging area로 이동
(커밋해시) : 해당 커밋으로 이동하며 이후의 커밋 기록이 삭제된다.
📌 git reflog 명령어를 사용하여 복구 가능

## revert
git rebert : 해당 커밋의 내용으로 새로운 커밋을 만들어 기존의 커밋 내용을 삭제하지 않는다

--no-commit : 커밋을 하지 않고 해당 커밋의 내용만 가져올 수 있다
📌 팀원들과 공유가 된 커밋에 대해서는 revert를 사용할 것

## restore
git restore (file명) : 해당 file을 working directory에서 제거 즉, 이전 상태로 되돌린다
--staged (file명) : 해당 file을 staging area에서 제거한다
--source=(커밋해시) (file명): 해당 file을 해당 커밋 상태로 되돌린다

git restore . 또는 git restore --staged . 등 사용 가능

## stash
git stash : 현재 작업들 치워두기(git stash save와 같음)
-p : hunk단위로 stash
-m : stash에 메시지 입력
list : stash 리스트 확인
apply : stash 리스트의 마지막 항목 적용
drop : 삭제
pop : 적용 및 삭제
branch (branch명) : 새 branch를 생성하고 pop한다. 충돌사항이 있는 상황에 유용하다
clear : stash list 비우기
📌명령어 마지막에 stash{num}을 사용해서 항목 지정이 가능하다

## clean
git clean (명령어) : 추적되지 않는 파일 삭제
-n : 삭제될 파일 리스트 확인
-i : 인터렉티브 모드 시작
-d : 폴더를 포함하여 보여주기
-f : 강제로 바로 삭제
-x : .gitignore에 등록된 파일들도 삭제

명령어를 조합해서 사용할 수 있다
보통 git clean -df 사용

## tag
|태그 종류|설명|
|---|---|
|lightweight|특정 커밋을 가리키는 용도|
|annotated|작성자 정보와 날짜, 메시지, GPG 서명포함 가능|
git tag : 현존하는 태그 확인
git tag (태그명) : 마지막 커밋에 태그 달기(lightweight)
git show (태그명) : 원하는 태그 확인
git tag -d (태그명) : 태그 삭제
git tag -a v2.0.0 : 마지막 커밋에 태그 달기(annotated). 입력후 태그 메시지 작성
git tag (태그명) -m "(메시지)" : 메시지까지 한 번에 작성. -m 태그가 -a태그 암시
git tag (태그명) (커밋 해시) -m (메시지) : 원하는 커밋에 태그 달기
git tag -l 'v1.*' : 원하는 패턴으로 필터링하기
git checkout (태그명) : 원하는 버전으로 checkout

📌 원격에 태그 동기화하기
git push (원격명) (태그명) : 특정 태그 원격에 올리기
git push --delete (원격명) (태그명) : 특정 태그 원격에서 삭제
git push --tags : 로컬의 모든 태그 원격에 올리기

📌[Semantic 버전](https://semver.org/lang/ko/)
2(Major).0(Minor).0(Patch)
Major : 기존 버전과 호환되지 않게 API가 바뀌면 주버전을 올리고
Minor : 기존 버전과 호환되면서 새로운 기능을 추가할 때는 부버전을 올리고
Patch : 기본 버전과 호환되면서 버그를 수정한 것이라면 수버전을 올린다

## log
git log : 커밋 내용을 확인할 수 있다
-p : 각 커밋마다의 변경사항 함께 보기
-(num) : 최든 num개 커밋만 보기
--stat : 통계와 함께 보기
--online : 한줄로 보기
-S (검색어) : 변경사항 내 단어 검색
--grep (검색어) : 커밋 메시지로 검색
--all : 모든 branch log 확인 가능
[기타 옵션들](https://git-scm.com/book/ko/v2/Git%EC%9D%98-%EA%B8%B0%EC%B4%88-%EC%BB%A4%EB%B0%8B-%ED%9E%88%EC%8A%A4%ED%86%A0%EB%A6%AC-%EC%A1%B0%ED%9A%8C%ED%95%98%EA%B8%B0#limit_options)

📌git log를 확인할 때 사용자가 원하는 방식으로 포메팅해서 확인할 수 있다
예)
```
git log --graph --all --pretty=format:'%C(yellow) %h  %C(reset)%C(blue)%ad%C(reset) : %C(white)%s %C(bold green)-- %an%C(reset) %C(bold red)%d%C(reset)' --date=short
```

## reflog
git reflog
프로젝트가 위치한 커밋이 바뀔 때 마다 기록되는 내역을 보여주고 이를 사용하여 reset하기 이전 시점으로 프로젝트를 복구할 수 있다

## diff
git diff : working directory에 있는 파일의 변경 사항을 알려준다
--staged : staging area에 있는 파일의 변경 사항을 알려준다
(commit1) (commit2) : commit간의 차이 확인
(branch1) (branch2) : branch간의 차이 확인

## blame
git blame (파일명) : 파일의 부분별로 작성자 확인하기
git blame -L (시작줄) (끝줄, 또는 +줄수) (파일명) : 특정 부분 지정해서 작성자 확인하기

## git bisect
git bisect : 이진 탐색 알고리즘으로 문제의 발생 시점을 찾아낸다
git bisect start : 이진 탐색 시작
git bisect bad : 오류발생 지점임을 표시
git checkout (해당 커밋 해시) : 의심 지점으로 이동
git bisect good : 오류 발생 않을 시 양호함 표시
♻️ 원인을 찾을 때까지 반복
git bisect good/bad
git bisect reset : 이진 탐색 종료

## HEAD와 "-"
HEAD~ : ~ 또는 ^ 갯수만큼 진행한다
예를 들어
git checkout HEAD~~ : 2단계 뒤로 이동
git reset HEAD~5 : 5단계 뒤로 reset

"-" : 바로 이전으로 이동
git switch - : 이전 branch로 이동
git checkout - : (그 전에 한 이동을) 한 단계 되돌리기

## config
git config (global) --list : 현재 모든 설정값 보기
git config (global) -e : 에디터에서 보기(기본:vi)
git config --global core.editor "code --wait"
또는 code 자리에 원하는 편집 프로그램의 .exe파일 경로 연결
--wait : 에디터에서 수정하는 동안 CLI를 정지
💡 git commit 등의 편집도 지정된 에디터에서 열게 됨

git config --global alias.(단축키) "명령어"
예시: git config --global alias.cam "commit -am"

## 기타
git rm (file명) : file을 삭제하고 파일의 삭제를 staging area에 등록
git mv (file명) (변경할 file명) : 이름 변경 후 staging area에 등록