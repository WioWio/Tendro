# Требования к проекту
## Содержание
1 [Введение](#intro) 
1.1 [Обозначение терминов](#termins)
1.2 [Назначение](#assigment)
1.3 [Аналоги](#analogs) 
2 [Требования пользователя](#user_requirements)  
2.1 [Программные интерфейсы](#software_interfaces)  
2.2 [Интерфейс пользователя](#user_interface)  
2.3 [Характеристики пользователей](#user_specifications)     
2.4 [Предположения и зависимости](#assumptions_and_dependencies)  
3 [Системные требования](#system_requirements)  
3.1 [Функциональные требования](#functional_requirements)  
3.2 [Нефункциональные требования](#non-functional_requirements)  
3.2.1 [Атрибуты качества](#quality_attributes)
3.2.2 [Бизнес требования](#business_requirements)

<a name="intro"/>

## 1. Введение

<a name="termins"/>

#### 1.1 Обозначение терминов
- ##### Тендер
Конкурентная форма отбора предложений на поставку товаров, оказание услуг или выполнение работ по заранее объявленным в документации условиям, в оговоренные сроки. Контракт заключается с победителем тендера — участником, подавшим предложение, соответствующее требованиям документации, в котором предложены наилучшие условия.
- ##### Критерий
Выбор победителя тендера происходит путём сравнения условий конкурсантов, которые состоят из трёх критериев: цены товара/услуги/работы, срок исполнения, условия оплаты.
- ##### Вскрытие
По правилам проведения конкурсов информация об предложениях конкурсантов находится в запечатанных конвертах, вскрытие которых производится в определённое время, единое для всех конкурсантов.
- ##### Бальная система
Сравнение происходит отдельно для каждого критерия. Самому выгодному для заказчика значению критерию ставится 10 баллов, наименее выгодному - 1 балл. Остальным значениям критерия выставляются баллы по приницпу распределения  между лучшим и худшим значениями. Далее высчитываются удельные баллы и суммируются в общий балл для каждого предложения. Тендер выигрывает предложение с наибольшим общим баллом. 
- ##### Коэффициент
Разные критерии имеют разную значимость для выбора победителя, что выражается в коэффициенте значимости (К<=1). Сумма коэффициентов трёх критериев составляет единицу.
- ##### Удельный балл
Балл, полученный одним из критериев предложения после сравнения всех предложений, умноженный на коэффициент значимости критерия. 

<a name="assignment"/>

#### 1.2 Назначение
Государственные организации и организации с госдолей распоряжаются бюджетными средствами по особым правилам. Выбор поставщика, подрядчика либо исполнителя услуг проводится на конкурсной основе. Данная программа предназначена для автоматизированного вычета победителя конкурсов на основе установленых в Республике Беларусь критериев, способов оценки и сравнения предложений при госзакупках. Для рассчётов применяется бальная система. Также в функционал программы входит напоминание о предстоящем вскрытии пакетов с тендерными заявками.

<a name="analogs"/>

#### 1.3 Аналоги
Аналогов Tendro на данный момент в общем доступе не существует. Процедуры, осуществляемые Tendro производятся работниками, в основном, вручную с использованием таблиц Exel.

<a name="user_requirements"/>

## 2. Требования пользователя

<a name="software_interfaces"/>

#### 2.1 Программные интерфейсы
Разрабатываемый проект будет реализован на языке Java c использованием библиотек JavaFX.

<a name="user_interface"/>

#### 2.2 Интерфейс пользователя
 Программа представляет собой окно, содержащее название конкурса, поле для ввода даты и времени вскрытия, поля для ввода коэффициентов, таблицу с условиями конкурсантов и баллами, кнопка рассчёта баллов и область с победителями конкурса.
 
 ![MainWindow](https://github.com/WioWio/Tendro/blob/master/Mockups/TendroMainWindow.png "MainWindow")
 
Пользователь может указать предмет закупки и время вскрытия пакета с тендерами. Уведомление поступит за 15 минут.

![Notification](https://github.com/WioWio/Tendro/blob/master/Mockups/NotificationWindow.png "Notification")
 
 Далее пользователю необходимо установить коэффициенты учитывания критериев: цены, срока поставки и условий оплаты.
 
 При таблице имеется кнопка добавления конкурсанта. При нажатии добавляется новая строка со своим порядковым номером. Пользователю доступны для ввода название организации и значения критериев. Остальные ячейки таблицы неактивны.
 
 При нажатии на ячейку условий оплаты всплывает окно для занесения подробной информации об условиях.
 
 ![PayConditions](https://github.com/WioWio/Tendro/blob/master/Mockups/PayConditionsInput.png "PayConditions")
 
 После ввода коэффициентов и информации о всех конкурсантах становится доступна кнопка "Рассчитать". По её нажатию расчитываются и заносятся в таблицу баллы и выводятся два лучших тендера.
 
 
 <a name="user_specifications"/>
 
 #### 2.3 Характеристики пользователей
Программа проста в использовании, поэтому она доступна любому пользователю, обладающему базовыми навыками работы с компьютером и таблицами. Программа предназначена для сотрудников государственных организаций, занимающихся закупками товаров и услуг.
<a name="system_requirements"/>

## 3. Системные требования
Для запуска данного приложения необходимо наличие компьютера с установленной Java Runtime Environment.
<a name="functional_requirements"/>

#### 3.1 Функциональные требования
Пользователь должен обладать следующими возможностями:
- Дать название конкурсу
- Внести дату и время вскрытия
- Получить уведомление за 15 минут до вскрытия
- Внести значения коэффициентов
- Внести данные о конкурсантах
- Получить значения рассчитанных баллов
- Получить информацию о двух первых победителях конкурса

<a name="non-functional_requirements"/>

#### 3.2 Нефункциональные требования

#### 3.2.1 Атрибуты качества
 - ##### Надёжность
Главным атрибутом качества данной программы является надежность вычислений. Должны быть учтены все критерии и правильно применены формулы подсчёта баллов.
- ##### Автоматизированность
Все вычисления должны производиться системой. Пользователю необходимо лишь вводить исходные данные.
 - ##### Простота
Программа должна выполнять только свои основные задачи и быть интуитивно понятной для использования.
- ##### Сдержанный графический интерфейс
Графический интерфейс должен быть не броским, таким, чтобы работнику было комфортно пользоваться программой в течение всего рабочего дня.

<a name="business_requirements"/>

#### 3.2.2 Бизнес требования
Алгоритм рассчёта победителя должен соответстовать бальной системе оценки и сравнения предложений участников конкурсов госзакупок Республики Беларусь.
