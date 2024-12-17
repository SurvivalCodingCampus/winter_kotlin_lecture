# git study

## git 사용 전 알아두어야할 git의 구조 및 기능
- repository는 local과 server 두 공간이 있다.
- local과 fork된 repository은 개인 공간으로 생각하면 될 듯 하다.
- 실제로 작업(협업)이 이루어지는 repository에만 최종적인 결과를 제출하면된다.
- server가 바로 본인이 작업하는 repository라면 local에서 push로 제출하는 구조가 되겠고,
 fork로 가져온 repository라면 pull request를 하여서 작업을 올려주면 된다.
  (그렇게 하면 해당 repository 관리자가 확인 후 repository를 수정하는 구조인 듯 하다.)

## git 사용을 위한 일련의 과정
- 우선 local에 repository를 만든다.
- server의 repository를 만들거나 다른 repository를 fork 한다.
- 이렇게 server의 repository를 만들었으면 local과 remote를 시켜준다.
- 에러사항) 사용하기 전에 pull로 repository를 당겨온 후 먼저 push가 이루어져야한다.
 그렇지 않으면 server와 local의 repository가 따로 놀게 되는데 
 이 경우 각 툴의 commit tree로 들어가 rebase 명령어 혹은 설정으로 local의 기록들을 연결시켜
 server와 local의 repository 구성을 일치시켜 주면 된다.