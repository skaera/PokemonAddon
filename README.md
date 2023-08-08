## 포켓몬 스크립트 애드온 (1.16.5)

```
포켓몬모드 (리포지드)의 이벤트를 스크립트에서 사용합니다.
```

## 주의
```
해당 플러그인은 Arclight에서만 작동합니다.
```

## 사용법

```
on poke catch (포켓몬 포획시 발동)
ㄴ event-pokemon ( 포켓몬 이름 반환 )
ㄴ event-poketype ( 포켓몬이 전설의 포켓몬인지 아닌지 구분 )
on poke kill (포켓몬 처치시 발동)
ㄴ event-pokemon ( 포켓몬 이름 반환 )
ㄴ event-poketype ( 포켓몬이 전설의 포켓몬인지 아닌지 구분 )
on beat trainer ( 트레이너 처치시 발동 )
ㄴ event-trainer ( 트레이너 이름 )
on lost to trainer
ㄴ event-trainer ( 트레이너 이름 )
```

## 예제
```
on poke catch:
  if event-poketype is "Legendary":
    broadcast "%player%님이 전설의 포켓몬을 포획하였습니다. (%event-pokemon%)"
on poke kill:
  if event-poketype is "Legendary":
    broadcast "%player%님이 전설의 포켓몬을 처치하였습니다. (%event-pokemon%)"
on beat trainer:
  if event-trainer is "배틀타워":
    set {배틀타워승리::%player%} to true
on lost to trainer:
  if event-trainer is "배틀타워":
    set {배틀타워패배::%player%} to true
```





























##경고
```
해당 애드온을 사용한 2차 창작 스크립트는 판매하지 말아주세요. 만일 판매시 프로필에 있는 메일로 연락 부탁드립니다.
```
