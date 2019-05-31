1 view三个方法
  onMeasure
  三种模式：exactly 父布局决定子布局大小
          unspecified 子布局任意大小
          at_most 最大可达到指定大小
  meausreChildren
  
  layout draw
  
  2. sp apply 同步存内存异步存磁盘 无返回值
        commit 同步存内存磁盘  有返回值
        
        第一次 get需要读磁盘 造成阻塞
        
        edit 创建对象editor  apply创建线程
       
  3 activity 异常重开 onPause onsavestate(保存状态) onStop onDestory oncreate onStart onRestore(恢复状态) onResume
    横竖屏切换
