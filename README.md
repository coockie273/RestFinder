# Restourant Finder
Реализованы пункты 1,2,3,5.

Пункт 4 реализован на половину, но возникла проблема с реализацией динамического условиия.
UPD: Были реализованы функции подбора ресторана по 3 критериям: Место нахождения, кухня, ключевое слово.

Код не в лучшем состоянии, версия очень сырая, большинство возможных проблем не было учтено. Клиент не был реализован, проверка функциональности проводится с помощью отправки запросов PostMan.

# Web Функционал
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
UPD:

- Post /RequestRestarauntForLocation - запрос ресторана по локации.
- Get /RequestRestarauntForKitchen - запрос ресторана по кухне.
- Get /RequestRestarauntForKitchen - запрос ресторана по ключевому слову.

  # Telegram bot
Ссылка: t.me/hsai_restaurant_finder_bot

Команды:
  - /start - начало выполнения программы, при вызове команды происходит signUp c id = chatId.
  - /show_preference - вывод предпочтений пользователя
  - /add_preference - добаление предпочтений пользователю
  - /delete_preference - удаление предпочтений пользователю
  - /add_restaraunt_to_visited - добавить ресторан в список посещенный пользователем
  - /delete_restaurant_from_visited - удалить ресторан из списка посещенных пользователем
  - /visited_list - вывод списка посещенных ресторанов
  - /random_restaurant - запрос случайного ресторана

# Примеры использования бота.
![image](https://github.com/coockie273/RestFinder/assets/103525603/8b8fc614-88bb-4b75-a1e1-84e6e673f64c)
![image](https://github.com/coockie273/RestFinder/assets/103525603/027a3367-7f1d-4627-b2a0-424951a1bc3c)


