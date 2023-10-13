# Restourant Finder
Реализованы пункты 1,2,3,5.

Пункт 4 реализован на половину, но возникла проблема с реализацией динамического условиия.

Код не в лучшем состоянии, версия очень сырая, большинство возможных проблем не было учтено. Клиент не был реализован, проверка функциональности проводится с помощью отправки запросов PostMan.

# Функционал
- Post /signUp - регистрация пользователя. Добавление пользователя в БД.
- Post /signIn - авторизация. На стороне пользователя добавляется кука с его Id.
- Get /showKeywordPreference - отображение предпочтений авторизованного пользователя.
- Get /showKitchenPreference - отображение предпочтений по кухне авторизованного пользователя.
- Post /addKeywordPreference - добавление предпочтения авторизованного пользователя.
- Post /addKitchenPreference - добавление предпочтения по кухне авторизованного пользователя.
- Get /deleteKeywordPreference - удаление предпочтения авторизованного пользователя.
- Get /deleteKitchenPreference - удаление предпочтения по кухне авторизованного пользователя.
- Post /addVisitedRestaraunt - добавить ресторан в список посещенных.
- Post /deleteRestarauntFromVisited - удаление ресторана из списка посещенных.
- Get /showVisitedRestaraunts - отображение списка посещенных ресторанов.
- Get /requestRandomRestaraunt - запрос случайного ресторана.
- Post /RequestRestaraunt - запрос ресторана по параметрам. Логика описана, динамическое условие запроса не было реализовано.