#쉘스크립트 용어

title="$(date -u +%Y-%m-%d)"
#-u 옵션: -u를 추가하면 date 명령어가 UTC 시간을 기준으로 날짜를 출력

daily_md="./docs/daily/$title.md"
#파일 경로 설정, 디렉터리 내에 md파일 생성

[ -d ./docs/daily/ ] || mkdir -p ./docs/daily/
#-d는 디렉터리(directory)인지 확인하는 조건
# mkdir는 "make directory"의 약자로, 새로운 디렉터리(폴더)를 생성하는 명령어

cat <(printf '# %s\n' "$title") ./til_template.md >> "$daily_md"
#cat 명령어를 사용해 출력된 제목과 ./til_template.md 파일의 내용을 연결해서 출력
# >> "$daily_md": 결과를 daily_md 파일에 추가(append)