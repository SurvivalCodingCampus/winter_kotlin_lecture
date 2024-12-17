### Github
소스코드 호스팅 서비스 제공
웹 호스팅 : 웹 서버 대여

<img width="346" alt="image" src="https://github.com/user-attachments/assets/85625c88-e1f9-43d9-ac5e-2d7f84014985" />


### Git 명령어
- 원격 저장소에 잘못 업로드 된 폴더 또는 파일 삭제
```text
git rm -r --cached .
```

- 새로운 브랜치를 생성하고 이동하는 명령어
```text
git checkout -b new
```

- merge 충돌이 발생했을 때 취소하는 명령어
```text
git merge --abort
```

- 원격 저장소 url 가져오기
```text
git remote add origin + 업로드 할 git 주소
git pull origin master(브랜치명)
```

- git clone vs git pull
    - git clone : 저장소 통채로 가져온다
    - git pull : 중간 업데이트 확인시 사용 / (+origin) 특정 브랜치만 가져올 수 있다

- git merge vs git rebase
  - git merge
    - 기록을 남긴다 (branch 통합)
    - 충돌을 하나의 커밋으로 해결 가능
  - git rebase : 기록을 새로 쓴다 (branch의 base를 옮긴다->git history 간결화)
    - 충돌이 일어날 때마다 해결해 주어야 한다
    - 동일한 커밋이더라도 새로운 해시값을 가짐

### gitignore
- 설정 목적 : 협업 중 서로 버전이 다를 경우 충돌 방지
- .gitignore파일은 최상위 폴더에 생성되어야 한다

### WSL
Linux용 Windows 하위 시스템.   
wsl를 사용하여 Ubuntu, Debian, Kali 등과 같은 다양한 Linux 배포를 설치하고 실행한다


### 회고
git에 대해서 공부했었고 사용도 해봤는데, 퀴즈를 풀면서 제대로 모른다고 느꼈다.
부끄럽지만 사용한지 오래되다보니 pull이랑 push조차 헷갈렸다. 반성하고 복기하며 부족한 부분을 채웠다.
rebase는 직접 협업하면서 더 경험해봐야 익숙해질거 같다.

### Follow up
현재 노트북에 wsl2 설치된 상태이고, docker로 했던거 같은데 기억이 잘 안난다.. 다시 확인해보기
