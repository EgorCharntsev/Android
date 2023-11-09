package com.itis.homework.utils

import com.itis.homework.R
import com.itis.homework.model.LyricsModel
import com.itis.homework.model.SongModel

object SongsRepository {
    private var songList = listOf<SongModel>()
    init {
        songList = listOf(
                SongModel(
                    id = 1,
                    name = "New Divide",
                    album = "New Divide",
                    author = "Linkin Park",
                    LyricsModel("[Verse 1]\n" +
                            "I remembered black skies\n" +
                            "The lightning all around me\n" +
                            "I remembered each flash\n" +
                            "As time began to blur\n" +
                            "Like a startling sign\n" +
                            "That fate had finally found me\n" +
                            "And your voice was all I heard\n" +
                            "That I get what I deserve\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "So give me reason\n" +
                            "To prove me wrong\n" +
                            "To wash this memory clean\n" +
                            "Let the floods cross\n" +
                            "The distance in your eyes\n" +
                            "Give me reason\n" +
                            "To fill this hole\n" +
                            "Connect this space between\n" +
                            "Let it be enough to reach the truth that lies\n" +
                            "Across this new divide\n" +
                            "\n" +
                            "[Verse 2]\n" +
                            "There was nothing in sight\n" +
                            "But memories left abandoned\n" +
                            "There was nowhere to hide\n" +
                            "The ashes fell like snow\n" +
                            "And the ground caved in\n" +
                            "Between where we were standing\n" +
                            "And your voice was all I heard\n" +
                            "That I get what I deserve\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "So give me reason\n" +
                            "To prove me wrong\n" +
                            "To wash this memory clean\n" +
                            "Let the floods cross\n" +
                            "The distance in your eyes\n" +
                            "Across this new divide\n" +
                            "\n" +
                            "[Bridge]\n" +
                            "In every loss in every lie\n" +
                            "In every truth that you deny\n" +
                            "And each regret and each goodbye\n" +
                            "Was a mistake too great to hide\n" +
                            "And your voice was all I heard\n" +
                            "That I get what I deserve\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "So give me reason\n" +
                            "To prove me wrong\n" +
                            "To wash this memory clean\n" +
                            "Let the floods cross\n" +
                            "The distance in your eyes\n" +
                            "Give me reason\n" +
                            "To fill this hole\n" +
                            "Connect this space between\n" +
                            "Let it be enough to reach the truth that lies\n" +
                            "Across this new divide\n" +
                            "Across this new divide\n" +
                            "Across this new divide"),
                    icon = R.drawable.new_divide,
                    isFavourites = false
                ),
                SongModel(
                    id = 2,
                    name = "whereareyou",
                    album = "whereareyou",
                    author = "niteboi",
                    LyricsModel("THIS SONG HAS NO LYRICS."),
                    icon = R.drawable.whereareyou,
                    isFavourites = false
                ),
                SongModel(
                    id = 3,
                    name = "In the End",
                    album = "Hybrid Theory",
                    author = "Linkin Park",
                    LyricsModel("[Verse 1: Mike Shinoda, Chester Bennington, Both]\n" +
                            "It starts with one\n" +
                            "One thing, I don't know why\n" +
                            "It doesn't even matter how hard you try\n" +
                            "Keep that in mind, I designed this rhyme\n" +
                            "To explain in due time, all I know\n" +
                            "Time is a valuable thing\n" +
                            "Watch it fly by as the pendulum swings\n" +
                            "Watch it count down to the end of the day\n" +
                            "The clock ticks life away, it's so unreal\n" +
                            "Didn't look out below\n" +
                            "Watch the time go right out the window\n" +
                            "Tryin' to hold on, d-didn't even know\n" +
                            "I wasted it all just to watch you go\n" +
                            "\n" +
                            "[Pre-Chorus: Mike Shinoda]\n" +
                            "I kept everything inside\n" +
                            "And even though I tried, it all fell apart\n" +
                            "What it meant to me will eventually be\n" +
                            "A memory of a time when I tried so hard\n" +
                            "\n" +
                            "[Chorus: Chester Bennington]\n" +
                            "I tried so hard and got so far\n" +
                            "But in the end, it doesn't even matter\n" +
                            "I had to fall to lose it all\n" +
                            "But in the end, it doesn't even matter\n" +
                            "\n" +
                            "[Verse 2: Mike Shinoda, Both]\n" +
                            "One thing, I don't know why\n" +
                            "It doesn't even matter how hard you try\n" +
                            "Keep that in mind, I designed this rhyme\n" +
                            "To remind myself how I tried so hard\n" +
                            "In spite of the way you were mockin' me\n" +
                            "Actin' like I was part of your property\n" +
                            "Remembering all the times you fought with me\n" +
                            "I'm surprised it got so far\n" +
                            "Things aren't the way they were before\n" +
                            "You wouldn't even recognize me anymore\n" +
                            "Not that you knew me back then\n" +
                            "But it all comes back to me in the end\n" +
                            "\n" +
                            "[Pre-Chorus: Mike Shinoda]\n" +
                            "You kept everything inside\n" +
                            "And even though I tried, it all fell apart\n" +
                            "What it meant to me will eventually be\n" +
                            "A memory of a time when I tried so hard\n" +
                            "\n" +
                            "[Chorus: Chester Bennington]\n" +
                            "I tried so hard and got so far\n" +
                            "But in the end, it doesn't even matter\n" +
                            "I had to fall to lose it all\n" +
                            "But in the end, it doesn't even matter\n" +
                            "[Bridge: Chester Bennington]\n" +
                            "I've put my trust in you\n" +
                            "Pushed as far as I can go\n" +
                            "For all this, there's only one thing you should know\n" +
                            "I've put my trust in you\n" +
                            "Pushed as far as I can go\n" +
                            "For all this, there's only one thing you should know\n" +
                            "\n" +
                            "[Chorus: Chester Bennington]\n" +
                            "I tried so hard and got so far\n" +
                            "But in the end, it doesn't even matter\n" +
                            "I had to fall to lose it all\n" +
                            "But in the end, it doesn't even matter"),
                    icon = R.drawable.in_the_end,
                    isFavourites = false
                ),
                SongModel(
                    id = 4,
                    name = "МИР",
                    album = "МИР",
                    author = "blago white",
                    LyricsModel("[Интро: The Walls Group & blago white]\n" +
                            "Oh, get a little rough and lonely\n" +
                            "No matter what's going on\n" +
                            "You give me peace, You comfort me\n" +
                            "You make it better, Your love never leaves\n" +
                            "And it don't stop (А-а, е)\n" +
                            "And You never—\n" +
                            "\n" +
                            "[Куплет 1]\n" +
                            "Горе ситуации\n" +
                            "Разделение нации, но они же братья\n" +
                            "Понимаю как это, ругаться с братом\n" +
                            "Понимаю, правда — это трудновато\n" +
                            "Понимаю, что не всегда всё понятно\n" +
                            "Круизный контроль, ищи меня в Вияно\n" +
                            "Почему-то чувствую себя иммигрантам\n" +
                            "Вроде дома, но всё равно инопланетянин\n" +
                            "\n" +
                            "[Бридж]\n" +
                            "Что в мире происходит?\n" +
                            "Живём по пословицам, важнее нашей совест\n" +
                            "Сделано по образу и подобию, сколько пролитый кровью? Молюсь днём и ночью\n" +
                            "Сколько стоит жизнь человека?\n" +
                            "Скажут цена и я скажу, что это неверно\n" +
                            "Понимаешь, что тут нету правильный ответы?\n" +
                            "Одинаковы дерьмо в разные туалеты\n" +
                            "\n" +
                            "[Куплет 2]\n" +
                            "И я на следующий\n" +
                            "Закрыт в студия-убежище\n" +
                            "Всегда говорили, что я медленный\n" +
                            "20-22 года Мелоди\n" +
                            "И что моя дочка увидит?\n" +
                            "Вот что называется мелодия в кризис\n" +
                            "Честно, брат, я люблю свою страну очень сильно\n" +
                            "И честно, брат, для этого мне не надо причина\n" +
                            "Честно, говорю со сердца на эти биты, е\n" +
                            "Честно, утром не стою, так что лучше пиши мне\n" +
                            "Пять утра, мы сидим и болтаем чё-то с Джигой\n" +
                            "Чокаемся чашки чая, обсуждаем жизнь\n" +
                            "Спокойствие на студейки\n" +
                            "Без индейки, каждый день благодарени\n" +
                            "Tha Malchik, но скоро будут дети\n" +
                            "Изливаю моё сердце в эти песни\n" +
                            "\n" +
                            "[Куплет 3]\n" +
                            "Самый обсуждаемый\n" +
                            "Уккуратно со словами, будь внимательным\n" +
                            "И если делаю — только по классике\n" +
                            "Сияю ярко, будто мои часики\n" +
                            "Подскажи мне стоимости свободы?\n" +
                            "Капуста любит вода, да, хорошая погода\n" +
                            "И если нету праздники, тогда мы найдём повод\n" +
                            "Ошибка — не ошибка, не ошибка — это опыт (Damn)\n" +
                            "И это просто жизнь\n" +
                            "В каждого из нас есть чутка Барта Симпсон (Кайф)\n" +
                            "Пойми, что ты не вины\n" +
                            "Мы все дочерей и сыны (Факты)\n" +
                            "Мы все мирный гражданины\n" +
                            "Все как этот мальчик на коробке Киндер\n" +
                            "Просто хотим в шоколаде быть красиво\n" +
                            "Боже, скажи, если это слишком\n" +
                            "Мир — мой состояние\n" +
                            "Большой чопа сзади меня, будто Яни\n" +
                            "Бросил универ, начала моё процветания\n" +
                            "Хотели дать мне комнату, а мальчик хотел здание\n" +
                            "Когда это выйдет, буду мужем\n" +
                            "Парад Померанцевы, семейка это супер\n" +
                            "Как я маме говорю, я скажу, что ты лучше\n" +
                            "Ребята, они уже купили тебя игрушек\n" +
                            "В ожидании с тобой увидеться, время настало\n" +
                            "И если батя будет в слезами\n" +
                            "Просто чё-то ему в линзы попала\n" +
                            "Моя дорогая, ты не плакай\n" +
                            "Токо плакай, если это слёзы радость\n" +
                            "Ты наши самые лучшие создания\n" +
                            "В мире будет ещё Померанцев\n" +
                            "[Скит]\n" +
                            "Ведь они понимают, что здесь это место создано для того, чтобы не стесняться, а там где им помогут (М-м), и не будут над ними смеяться, понимаешь. Они приходят для того, чтобы, ты, твоя обязанность делать так, чтобы им было комфортно, чтобы они понимали, что ты с ними на одной волне\n" +
                            "\n" +
                            "[Аутро]\n" +
                            "Это моя молитва\n" +
                            "Да не, это наш молитва\n" +
                            "По правде только одна битва\n" +
                            "Битва сам с собой и свой единица\n" +
                            "Пусть мы все будем мирный\n" +
                            "Давайте друг другу любите\n" +
                            "Если нет, что мой плод увидит?\n" +
                            "Спаси и сохрани наши детишки\n" +
                            "Амин"),
                    icon = R.drawable.mir,
                    isFavourites = false
                ),
                SongModel(
                    id = 5,
                    name = "25 к 10",
                    album = "Акустика",
                    author = "Аквариум",
                    LyricsModel("[Куплет 1]\n" +
                            "Я инженер на сотню рублей\n" +
                            "И больше я не получу\n" +
                            "Мне двадцать пять, и я до сих пор\n" +
                            "Не знаю, чего хочу\n" +
                            "И мне кажется, нет никаких оснований\n" +
                            "Гордиться своей судьбой\n" +
                            "Но если б я мог выбирать себя\n" +
                            "Я снова бы стал собой\n" +
                            "\n" +
                            "[Куплет 2]\n" +
                            "Мне двадцать пять, и десять из них\n" +
                            "Я пою, не зная, о чем\n" +
                            "И мне так сложно бояться той\n" +
                            "Что стоит за левым плечом\n" +
                            "И пускай мои слова не ясны\n" +
                            "В этом мало моей вины\n" +
                            "Но что до той, что стоит за плечом\n" +
                            "Перед нею мы все равны\n" +
                            "\n" +
                            "[Куплет 3]\n" +
                            "Может статься, что завтра стрелки часов\n" +
                            "Начнут вращаться назад\n" +
                            "И тот, кого с плачем снимали с креста\n" +
                            "Окажется вновь распят\n" +
                            "И нежные губы станут опять\n" +
                            "Искать своего Христа\n" +
                            "Но я пел, что пел, и хотя бы в том\n" +
                            "Совесть моя чиста\n" +
                            "\n" +
                            "[Куплет 4]\n" +
                            "Я счастлив тем, как сложилось все\n" +
                            "Даже тем, что было не так\n" +
                            "Даже тем, что ветер в моей голове\n" +
                            "И в храме моем бардак\n" +
                            "Я просто пытался растить свой сад\n" +
                            "И не портить прекрасный вид\n" +
                            "И начальник заставы поймет меня\n" +
                            "И беспечный рыбак простит"),
                    icon = R.drawable.acustica,
                    isFavourites = false),
                SongModel(
                    id = 6,
                    name = "Сохрани меня",
                    album = "Сохрани меня",
                    author = "Кирилл Гуд",
                    LyricsModel("[Интро]:\n" +
                            "Сохрани меня\n" +
                            "В своей фотопленке, если чувства сильные\n" +
                            "Прожигают твою кожу из последних сил\n" +
                            "Я бегу к тебе, хоть рейс последний пропустил\n" +
                            "\n" +
                            "[Куплет 1]: Кирилл Гуд\n" +
                            "Нет, я не забыл\n" +
                            "Как мы искали с тобой вдвоём счастье\n" +
                            "Сбивая все ноги в кровь, страсти\n" +
                            "Хватало с лихвой\n" +
                            "\n" +
                            "[Бридж]: \n" +
                            "Поцелуи на шее твои\n" +
                            "Камера, мотор (yeah-yeah)\n" +
                            "Прогони мою боль (yeah-yeah)\n" +
                            "Минор и мажор, инь - янь\n" +
                            "\n" +
                            "[Припев]:\n" +
                            "Вода и огонь, искра\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "\n" +
                            "Оно так искренно стучит\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "\n" +
                            "[Куплет 2]: Кирилл Гуд\n" +
                            "Оно так искренно стучит\n" +
                            "Ты запускаешь сердце на орбиту\n" +
                            "Мы с тобой ускорены, снова врубаем нитро\n" +
                            "Нейтрализуем все разговоры вокруг\n" +
                            "\n" +
                            "Ведь нас не волнуют они\n" +
                            "Меня волнуешь лишь ты\n" +
                            "Как вода утекай\n" +
                            "Без тебя день - это дико\n" +
                            "\n" +
                            "Без тебя два - я как дикарь\n" +
                            "Без тебя три - я убит… (POW!)\n" +
                            "И снова тот же стиль\n" +
                            "Я бегу к тебе, хоть рейс последний пропустил\n" +
                            "\n" +
                            "Нет, я не забыл\n" +
                            "Как мы искали с тобой вдвоём счастье\n" +
                            "Сбивая все ноги в кровь, страсти\n" +
                            "Хватало с лихвой\n" +
                            "\n" +
                            "[Бридж]: \n" +
                            "Поцелуи на шее твои\n" +
                            "Камера, мотор (yeah-yeah)\n" +
                            "Прогони мою боль (yeah-yeah)\n" +
                            "Минор и мажор, инь - янь\n" +
                            "\n" +
                            "[Припев]: \n" +
                            "Вода и огонь, искра\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "\n" +
                            "Оно так искренно стучит\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "\n" +
                            "Оно так искренно стучит\n" +
                            "И пусть нашу историю любви не снимет ни один крутой режиссёр, ну и пусть\n" +
                            "Оставим наш сценарий между нами\n" +
                            "Как бы не был далеко помни, что я вернусь\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "Оно так искренно стучит\n" +
                            "У-у-у, Заблокируй номера всех бывших, детка\n" +
                            "\n" +
                            "Они точно тебе больше не нужны\n" +
                            "Смотрю сквозь твоё тело и вижу сердце\n" +
                            "Оно так искренно стучит\n" +
                            "Заблокируй номера\n" +
                            "\n" +
                            "[Аутро]: \n" +
                            "Сохрани меня\n" +
                            "В своей фотопленке, если чувства сильные"),
                    icon = R.drawable.save_me,
                    isFavourites = false),
                SongModel(
                    id = 7,
                    name = "Excused",
                    album = "Excused",
                    author = "Lowx",
                    LyricsModel("[Intro]\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "\n" +
                            "[Refrain]\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "\n" +
                            "[Bridge]\n" +
                            "(I'm haunted, haunted, haunted)\n" +
                            "(I'm haunted, haunted, haunted)\n" +
                            "\n" +
                            "[Refrain]\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "I'm haunted, haunted, haunted\n" +
                            "\n" +
                            "[Verse]\n" +
                            "I took up too much space when I wasnext to you\n" +
                            "But now, it's just me all alone in this damn room\n" +
                            "Can't sleep, imaginin' the things to say to you (Won't say to you)\n" +
                            "\n" +
                            "[Refrain]\n" +
                            "(I'm haunted, haunted, haunted)\n" +
                            "(I'm haunted, haunted, haunted)"),
                    icon = R.drawable.excused,
                    isFavourites = false
                ),
                SongModel(
                    id = 8,
                    name = "Come and Get Your Love",
                    album = "Disco $ Pop Passion",
                    author = "Redbone",
                    LyricsModel("[Intro]\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "\n" +
                            "[Verse 1]\n" +
                            "Hail (Hail), what's the matter with your head, yeah\n" +
                            "Hail (Hail), what's the matter with your mind\n" +
                            "And your sign an-a, oh-oh-oh\n" +
                            "Hail (Hail), nothin' the matter with your head\n" +
                            "Baby find it, come on and find it\n" +
                            "Hail, with it, baby, 'cause you're fine\n" +
                            "And you're mine, and you look so divine\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "\n" +
                            "[Verse 2]\n" +
                            "Hail (Hail), what's the matter with you feel right\n" +
                            "Don't you feel right, baby\n" +
                            "Hail, oh yeah, get it from the main vine, all right\n" +
                            "I said-a find it, find it, go on and love it if you like it, yeah\n" +
                            "Hail (Hail), it's your business if you want some, take some\n" +
                            "Get it together, baby\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "\n" +
                            "[Bridge]\n" +
                            "Come and get your love, come and get your love\n" +
                            "Come and get your love, now\n" +
                            "Come and get your love, come and get your love\n" +
                            "Come and get your love, now\n" +
                            "Come and get your love, come and get your love\n" +
                            "Come and get your love, now\n" +
                            "Come and get your love, come and get your love\n" +
                            "Come and get your love, now\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "Come and get your love\n" +
                            "\n" +
                            "[Verse 3]\n" +
                            "Hail (Hail), what's the matter with you feel right\n" +
                            "Don't you feel right, baby\n" +
                            "Hail, oh yeah, get it from the main vine, alright\n" +
                            "[Outro]\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, woohoo\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, na, na, na, na, na, da, boom\n" +
                            "Come and get your love\n" +
                            "La, da boom, boom, boom, ta, daba, boom, boom\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, woohoo\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, woohoo\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, da boom, boom, boom, ta, daba, boom, boom\n" +
                            "Come and get your love\n" +
                            "La, da boom, boom, boom, ta, daba, boom, boom\n" +
                            "Come and get your love\n" +
                            "La, da boom, boom, boom, ta, daba, boom, boom\n" +
                            "Come and get your love\n" +
                            "La, da boom, boom, boom, ta, daba, boom, boom\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, la\n" +
                            "Come and get your love\n" +
                            "La, la, la, la, la, la, la, la, la, woohoo\n" +
                            "Come and get your love"),
                    icon = R.drawable.come_and_det,
                    isFavourites = false
                ),
                SongModel(
                    id = 9,
                    name = "Black in Black",
                    album = "Highway To Melbourne",
                    author = "AC/DC",
                    LyricsModel("[Verse 1]\n" +
                            "Back in black, I hit the sack\n" +
                            "I've been too long, I'm glad to be back\n" +
                            "Yes, I'm let loose from the noose\n" +
                            "That's kept me hanging about\n" +
                            "I'm just looking at the sky 'cause it's getting me high\n" +
                            "Forget the hearse, 'cause I'll never die\n" +
                            "I got nine lives, cat's eyes\n" +
                            "Abusing every one of them and running wild\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "'Cause I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back, back\n" +
                            "Well, I'm back in black\n" +
                            "Yes, I'm back in black\n" +
                            "\n" +
                            "[Verse 2]\n" +
                            "Back in the back of a Cadillac\n" +
                            "Number one with a bullet, I'm a power pack\n" +
                            "Yes, I'm in a bang with a gang\n" +
                            "They've got to catch me if they want me to hang\n" +
                            "'Cause I'm back on the track and I'm beatin' the flack\n" +
                            "Nobody's gonna get me on another rap\n" +
                            "So, look at me now, I'm just making my play\n" +
                            "Don't try to push your luck, just get out of my way\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "'Cause I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back, back\n" +
                            "Well, I'm back in black\n" +
                            "Yes, I'm back in black\n" +
                            "\n" +
                            "[Guitar Solo]\n" +
                            "\n" +
                            "[Chorus]\n" +
                            "Well, I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back\n" +
                            "Yes, I'm back\n" +
                            "Well, I'm back, back\n" +
                            "Well, I'm back in black\n" +
                            "Yes, I'm back in black, yow\n" +
                            "\n" +
                            "[Bridge]\n" +
                            "Ah, yeah\n" +
                            "Oh, yeah\n" +
                            "Take my love\n" +
                            "Yeah, yeah\n" +
                            "Yeah\n" +
                            "Ah, hey yeah\n" +
                            "Ooh, yeah\n" +
                            "[Chorus]\n" +
                            "Well, I'm back (I'm back)\n" +
                            "Back (Well, I'm back)\n" +
                            "Back (I'm back)\n" +
                            "Back (I'm back)\n" +
                            "Back (I'm back)\n" +
                            "Back, back in black\n" +
                            "Yes, I'm back in black\n" +
                            "\n" +
                            "[Outro]\n" +
                            "I've hit the sack\n" +
                            "\n" +
                            "[Guitar Solo]"),
                    icon = R.drawable.black_in_black,
                    isFavourites = false
                ),
                SongModel(
                    id = 10,
                    name = "Cyber City",
                    album = "Cyber City",
                    author = "KSLV Noh",
                    LyricsModel("THIS SONG HAS NO LYRICS."),
                    icon = R.drawable.cyber_city,
                    isFavourites = false
                ),
                SongModel(
                    id = 11,
                    name = "Muddy",
                    album = "Muddy",
                    author = "plenka",
                    LyricsModel("THIS SONG HAS NO LYRICS."),
                    icon = R.drawable.muddy,
                    isFavourites = false
                ),
                SongModel(
                    id = 12,
                    name = "SimpsonWave1995",
                    album = "FrankJavCee Collection, Vol. 1, Pt. II",
                    author = "FrankJavCee",
                    LyricsModel("THIS SONG HAS NO LYRICS."),
                    icon = R.drawable.simpson_wave,
                    isFavourites = false
                ),
                SongModel(
                    id = 13,
                    name = "Gas Gas Gas",
                    album = "Initial D Hell",
                    author = "Dave Rodgers",
                    LyricsModel("[Intro]\n" +
                            "Ahhhh\n" +
                            "(Gas, gas, gas)\n" +
                            "Ahhhh\n" +
                            "Do you like my car?\n" +
                            "(My car, my car,)\n" +
                            " \n" +
                            "[Verse 1]\n" +
                            "Guess you're ready\n" +
                            "'Cause I'm waiting for you\n" +
                            "It's gonna be so exciting!\n" +
                            "Got this feeling\n" +
                            "Really deep in my soul\n" +
                            "Let's get out, I wanna go\n" +
                            "Come along... get it on!\n" +
                            " \n" +
                            "[Pre-Refrain]\n" +
                            "Gonna take my car\n" +
                            "Gonna see me\n" +
                            "Gonna drive along 'til I get you\n" +
                            "'Cause I'm crazy... hot and ready\n" +
                            "But you'll like it!\n" +
                            "I wanna race for you!\n" +
                            "Shall I go now?\n" +
                            " \n" +
                            "[Refrain]\n" +
                            "Gas gas gas!\n" +
                            "I'm gonna step on the gas\n" +
                            "Tonight I'll fly!\n" +
                            "And be your lover\n" +
                            "Yeah yeah yeah!\n" +
                            "I'll be so quick as a flash\n" +
                            "And I'll be your hero\n" +
                            " \n" +
                            "Gas gas gas!\n" +
                            "I'm gonna run as a flash\n" +
                            "Tonight I'll fight!\n" +
                            "To be the winner\n" +
                            "Yeah yeah yeah!\n" +
                            "I'm gonna step on the gas\n" +
                            "And you'll see the big show!\n" +
                            " \n" +
                            "[Verse 2]\n" +
                            "Don't be lazy\n" +
                            "'Cause I'm burning for you\n" +
                            "It's like a hot sensation!\n" +
                            "Got this power\n" +
                            "That is taking me out\n" +
                            "Yes, I've got a crush on you\n" +
                            "Ready, now\n" +
                            "Ready, go!\n" +
                            " \n" +
                            "[Pre-Refrain]\n" +
                            "Gonna take my car\n" +
                            "Gonna see me\n" +
                            "Gonna drive along 'til I get you\n" +
                            "'Cause I'm crazy... hot and ready\n" +
                            "But you'll like it!\n" +
                            "I wanna race for you!\n" +
                            "Shall I go now?\n" +
                            " \n" +
                            "[Refrain]\n" +
                            "Gas gas gas!\n" +
                            "I'm gonna step on the gas\n" +
                            "Tonight I'll fly!\n" +
                            "And be your lover\n" +
                            "Yeah yeah yeah!\n" +
                            "I'll be so quick as a flash\n" +
                            "And I'll be your hero\n" +
                            " \n" +
                            "Gas gas gas!\n" +
                            "I'm gonna run as a flash\n" +
                            "Tonight I'll fight!\n" +
                            "To be the winner\n" +
                            "Yeah yeah yeah!\n" +
                            "I'm gonna step on the gas\n" +
                            "And you'll see the big show!\n" +
                            " \n" +
                            "[Solo]\n" +
                            " \n" +
                            "[Verse 1 Repeated]\n" +
                            "Guess you're ready\n" +
                            "'Cause I'm waiting for you\n" +
                            "It's gonna be so exciting!\n" +
                            "Got this feeling\n" +
                            "Really deep in my soul\n" +
                            "Let's get out, I wanna go\n" +
                            "Come along, get it on\n" +
                            " \n" +
                            "[Pre-Refrain]\n" +
                            "Gonna take my car\n" +
                            "Do you like my car?\n" +
                            "'Cause I'm crazy... hot and ready\n" +
                            "But you'll like it!\n" +
                            "I wanna race for you!\n" +
                            "Shall I go now?\n" +
                            " \n" +
                            "[Refrain]\n" +
                            "Gas gas gas!\n" +
                            "I'm gonna step on the gas\n" +
                            "Tonight I'll fly!\n" +
                            "And be your lover\n" +
                            "Yeah yeah yeah!\n" +
                            "I'll be so quick as a flash\n" +
                            "And I'll be your hero\n" +
                            " \n" +
                            "Gas gas gas!\n" +
                            "I'm gonna run as a flash\n" +
                            "Tonight I'll fight!\n" +
                            "To be the winner\n" +
                            "Yeah yeah yeah!\n" +
                            "I'm gonna step on the gas\n" +
                            "And you'll see the big show!\n" +
                            " \n" +
                            "[Outro]\n" +
                            "Gas gas gas!\n" +
                            "Yeah yeah yeah!\n" +
                            "Gas gas gas!\n" +
                            "And you'll see the big show!\n" +
                            " \n" +
                            "Ahhhhh\n"),
                    icon = R.drawable.gas_gas_gas,
                    isFavourites = false
                ),
                SongModel(
                    id = 14,
                    name = "Night Drive",
                    album = "Night Drive",
                    author = "Wilee",
                    LyricsModel("THIS SONG HAS NO LYRICS."),
                    icon = R.drawable.night_drive,
                    isFavourites = false
                ),
            )
        }

}
