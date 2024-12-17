#!/usr/bin/env sh

date_fmt="$(date -u +%Y-%m-%d)"
name='손세림'
merge_to="student/05-$name"
title="[$date_fmt] $name - 과제 제출"

gh pr create --base "$merge_to" \
    --title "$title" \
    -T pull_request_template.md \
    --editor "$@"
