# Quick Online Mod
没错，这是一款可以让你和你的朋友们可以更快捷的联机而准备的。

修改一下配置文件，进入游戏打一行命令即可让你化身房主，与朋友们一起玩MC

****
注意：
> 1. 此模组基于[OpenFRP](https://www.openfrp.net/)制作，所有你需要拥有一个OpenFRP账号
> 2. 请不要动**config/QuickOnlineMod/frpc.exe**程序，这是联机过程中**至关重要**的程序

此模组使用了OpenFRP OpenAPI

****
## 如何使用？

1. 前往[OpenFRP](https://www.openfrp.net/)创建账号，并进行实名认证
2. 在[控制台主页](https://console.openfrp.net/dashboard)中，复制你的访问密钥 
3. 确认自己的隧道资源有剩余（新创建的用户可直接下一步）
4. 将此模组安装进游戏，并启动一次以创建配置文件
5. 打开**config/QuickOnlineMod/config.json**并填入[相关信息](#我应该在配置文件里填写什么呢)（**仅用于和OpenAPI进行通信，我们不会收集任何用户的任何信息**）
6. 再次启动游戏，进入到想和朋友一起玩的地图
7. 开启对局域网开放，此时模组会自动保存端口号，无需在意
8. 执行命令【/quickonlinemod start】，并稍等片刻
9. 在输出的节点列表中选择**在地理方面**更接近自己和朋友的地区，并点击
10. 稍作等候，如果成功创建并开启，游戏内会提示一条蓝色下划线信息，点击复制就可以发给朋友们一起玩游戏了

## 我应该在配置文件里填写什么呢
在配置文件里，有三个字段，分别是：
1. user字段：填写创建账号时的邮箱
2. password字段：填写创建账号时的邮箱
3. key字段，填写自己的访问密钥（上文第二步）


再次强调：我们不会收集任何用户的任何信息，上述三条信息仅用来开启联机隧道

