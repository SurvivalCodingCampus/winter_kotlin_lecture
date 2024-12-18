# 필수 git 명령어 
1. git init
2. git add
3. git status
4. git log
5. git commit
6. git clone
7. git pull
8. git push

# git 버전 확인
   git --version

# 브랜치
브랜치란 독립적으로 어떤 작업을 진행하기 위한 개념이다. 필요에 의해 만들어지는
각각의 브랜치는 다른 브랜치의 영향을 받지 않기 때문에, 여러 작업을 동시에 진행 할 수있다.

## Git Reset

### Git Reset의 세 가지 모드:
- soft: 커밋만 되돌리고 변경된 파일은 staged 상태로 유지
- mixed` (기본값): 커밋과 staging 영역을 되돌리고, 변경된 파일은 unstaged 상태로 유지
- hard`: 커밋, staging 영역, 작업 디렉토리 모두를 되돌림 (⚠️ 주의: 작업 내용이 영구적으로 삭제될 수 있음)

### 사용 예시:
- git reset --soft HEAD~1  # 최근 커밋을 취소하고 변경사항을 staged 상태로 유지
- git reset --mixed HEAD~1 # 최근 커밋을 취소하고 변경사항을 unstaged 상태로 유지
- git reset --hard HEAD~1  # 최근 커밋을 완전히 제거하고 모든 변경사항을 삭제

## Branch

- git checkout 브랜치명 (브랜치 바꾸기, 커밋하고 깨끗한 상태로 할것)
- git checkout -b 브랜치명 (브랜치 만들고 이동)

## Branch 병합

### Merge

기능: 두 브랜치의 히스토리를 병합하며, 새로 병합 커밋(merge commit)을 생성한다.

### Merge의 장점

- 두 브랜치의 작업 히스토리를 그대로 유지한다.
- 팀 협업에서 작업 이력을 명확히 추적하기 쉽다.

### Rebase의 장점

기능: 한 브랜치의 작업 내용을 다른 브랜치 위로 재배치하여 히스토리를 재작성한다.

**장점**

- 깔끔하고 직관적인 히스토리를 유지할 수 있다.
- 커밋 히스토리가 간단해져서 프로젝트 유지보수가 쉬워진다.