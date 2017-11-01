# MVP

View层职能，负责展示UI，提供方法供P调用。规范如下：
1.	View层只负责UI展示，不得含有逻辑控制，比如，判断逻辑，即便是含有一个boolean的判断也要放到P层去做判断，以便以后的单元测试用例可以涵盖到所有的逻辑。
2.	View层中，可以包含UI属性的判断，如：view.isShown(),view.hasFocus()等。
3.	View层的方法通过接口引用提供给P层调用，且只能P层调用。
4.	View可以是Activity，可以是Fragument。
5.	点击事件，onActivityResult, 页面跳转，接收Intent数据等操作，放到P层处理。
6.	在Activity或者Fragment的onDestory方法中要回收除String外的所有引用型的实例，setNull(Object object)。
7.	现有的View层定义大部分是封装了一个View的类，以后直接在Activity或者Fragument中定义View，Activity或者Fragument就当成View。

Presenter层负责从M层获取数据，根据业务处理数据，调用View层方法更新UI。规范如下：
1.	Presenter的构造传入View的接口引用，以便Presenter调用View层的方法。
2.	Presenter层可以持有Model层接口的引用。
3.	Presenter层调用Model层的网络请求，回调统一使用ModelListener
4.	Presenter层的onDestory中回收除String外的所有引用型的实例。

Model层负责从Dao以及Server端获取数据，规范如下：
1.	Model层不持有View层，以及Presenter的引用。
2.	Model层不做数据处理，只负责获取数据，具体的数据处理由P层来做。
3.	当View层需要的数据和Model层返回的数据不匹配时候，由P层做数据上的兼容，允许自定义bean来对View层和Model层的数据做兼容。
