#!/usr/bin/env zsh
title="$(date -u +%Y-%m-%d)"
daily_md="./docs/daily/$title.md"

[ -d ./docs/daily/ ] || mkdir -p ./docs/daily/
if [ ! -f ./til_template.md ]; then
  echo "error: no template found." >&2
fi

cat <(printf '# %s\n' "$title") ./til_template.md >> "$daily_md"
ln -sf "$daily_md" today.md

printf "\n- [%s](%s): <insert description>" "$title" "$daily_md" >> "TOC.md"
