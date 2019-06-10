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
    
  4 activity 四种启动模式 standard singleTop singleTask singleInstance
    singleTask 如果未设置不同的taskAffinity 则还是在原来的task启动，反之在新的task里面启动activity
    
  5.如何加载一张大图？ 先通过inJustDecodeBound = true,禁止分配内存，再做图片压缩，inSampleSize压缩参数
    LruCache可缓存数据

  6.Rxjava用了方法注解跟参数注解的方式，注解的底层实现是动态代理
    注解可分为类注解 方法注解 参数注解 变量注解
  
  7.HandlerThread是Thread子类，内部自带Looper,可重复使用线程，减小开销，如果线程比较耗时，则后续操作会延迟
  
  8.include  ViewStub merge不同的使用场景
