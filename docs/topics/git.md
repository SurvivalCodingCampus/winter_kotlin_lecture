### Github
![스크린샷 2024-12-16 200322](https://github.com/user-attachments/assets/9cb6b9d4-bfb9-4202-aaa9-d40dade546a3)   
소스코드 호스팅 서비스 제공   
웹 호스팅 : 웹 서버 대여

### Git 명령어

- 원격 저장소에 잘못 업로드 된 폴더 또는 파일 삭제

```shell
git rm -r --cached .
```

- 새로운 브랜치를 생성하고 이동하는 명령어

```shell
git checkout -b new
```

- merge 충돌이 발생했을 때 취소하는 명령어

```shell
git merge --abort
```

- 원격 저장소 url 가져오기

```shell
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

- git 주의사항
    - remote에 push안 해 놓고 hard reset하면 다 날아간다
    - remote에서 변경하면 local에선 모르니까 git fetch로 비교한 후 pull진행

### gitignore

- 설정 목적 : 협업 중 서로 버전이 다를 경우 충돌 방지
- .gitignore파일은 최상위 폴더에 생성되어야 한다

### WSL

Linux용 Windows 하위 시스템   
wsl를 사용하여 Ubuntu, Debian, Kali 등과 같은 다양한 Linux 배포를 설치하고 실행한다


