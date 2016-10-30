写一个停车场程序,这个停车场可以取车可以停车, 车满不能停;
Parkinglot
  park
    Not full
    park and park again
    full
  unpark
    car in parkinglot
    car not in parkinglot

写实(对应现实)
抽取相关对象
定义对象行为


    Parkinglot
      park
        Not full
        park and park again
        full
      release
        car in parkinglot
        car not in parkinglot
    car
      park
      leave

练习2: 停车伙计现在我们雇佣了一个停车伙计. 伙计可以管理多个停车场,帮助客人停车取车.
      他停车的策略很简单,那个停车场有空位就停在那里;

练习3: 聪明停车伙计,停车场越来越多,原来一个伙计都不够用了,我们又雇佣了一个,
      这次的伙计比较聪明,他会判断哪个停车场的空位较多,然后把车停在那;

练习4: 停车生意越做越大,,我们的伙计那么多,当然得招一个"职业经理人"了,MBA毕业的,
      他现在管着好几个停车伙计,当然同时也管着好几个停车场,他可以直接代客停车,也可以把车交给某个伙计来停.

练习5: 打印停车场和服务生,我们到底有多少停车场了,是不是需要了解一下? 找停车经理吧,他会随时给我们汇报,
      比如,他当前以及他手下伙计管理的所有停车场,打印出他当前以及他手下伙计们的名字和对应的停车场,各个停车场的停车情况;