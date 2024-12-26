package org.example.domain.behavior.skills

interface SkillMessageProvider {
    fun getSkillSuccessMessage(skillName: String, effect: String?): String = "${skillName}을 시전 했습니다. $effect"
    fun getUnknownSkillFailMessage(): String = "해당 스킬을 사용할 수 없습니다"
    fun getSkillNotEnoughMpMessage(): String = "마나가 부족 합니다"
}