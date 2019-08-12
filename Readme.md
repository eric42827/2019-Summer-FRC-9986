2019FRC 9986 Code
===
## Instuction
- ## FRC Team 9986 Deep Space Robot Code @ TaiChuang, Taiwam 20190817-18
- ### branch master is written by student Unreallin01
- ### branch whole include the whole robot system with Command Subsystem structure
## 程式碼版本更新
### 2018/07/28-Rev.1
1. 新增 Command架構
2. 新增 讀取Gryo參數Function
3. 新增 PID控制器旋轉補償

### 2018/08/01-Rev.2
1. 新增 常用公式 => Constrain,Boolean_To_Int etc.
2. 新增 PID控制器自動介入及解除

### 2018/08/02-Rev.3
1. 修正 常用公式Bug => Boolean_To_Int
2. 新增 Timer至PID控制器自動介入及解除

### 2018/08/04-REV.4
1. 新增 搖桿雙重比率控制系統
**Google能力很重要!!**

### 2018/08/11-Whole branch complete
1. Although we complete the code,we don't use the lift because some structure problem.
2. The original panel was dropped ,we use simpler claw from Team 6191
## 教學網站
### FRC
[FRC Programming Done Right](https://frc-pdr.readthedocs.io/en/latest/index.html?fbclid=IwAR276i1ZUqSgFHWxyXhrEKqihKN7qGrL4gE5BOkGGf-nQCi8M8I0rjGfF_Y)
[FRC Control System](https://wpilib.screenstepslive.com/s/4485)
### Java
[語言技術：Java Gossip](https://openhome.cc/Gossip/Java/index.html)
[Java程式語言教學](https://programming.im.ncnu.edu.tw/J_index.html)
[Java Tutorial](https://www.tutorialspoint.com/java/index.htm)
![](https://i.imgur.com/FJgbQjA.png)
### TFG-Robot Code
#### Daniel
```java=
package frc.robot;
 
import edu.wpi.first.wpilibj.TimedRobot;
 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Solenoid;
 
public class Robot extends TimedRobot{
 
    private Joystick m_stick;
    WPI_TalonSRX lf;
    WPI_TalonSRX lr;
    WPI_TalonSRX rf;
    WPI_TalonSRX rr;
    MecanumDrive robot_Drive;
    VictorSP lift;
    VictorSP arml;
    VictorSP armr;
    VictorSP intake;
    SpeedControllerGroup arm;
    Timer m_timer;
    Solenoid claw;
    
    public void robotInit()
    {
        lf = new WPI_TalonSRX(1);
        lr = new WPI_TalonSRX(2);
        rf = new WPI_TalonSRX(4);
        rr = new WPI_TalonSRX(3);
       robot_Drive = new MecanumDrive(lf, lr, rf, rr);
        m_timer = new Timer();
        lift = new VictorSP(6);
        arml = new VictorSP(4);
        armr = new VictorSP(0);
        arml.setInverted(true);
        arm = new SpeedControllerGroup(arml, armr);
        m_stick = new Joystick(0);
        claw = new Solenoid(0);
        intake = new VictorSP(1);
    }
    public void autonomousInit()
    {
        m_timer.reset();
        m_timer.start();
    }
    public void autonomousPeriodic()
    {
    
    }
    public void teleopInit()
    {
    
    }
    public void teleopPeriodic()
    {
        robot_Drive.driveCartesian(m_stick.getRawAxis(1) * -0.5, m_stick.getRawAxis(0) * 0.5, m_stick.getRawAxis(4) * 0.3);
        
        lift.set(m_stick.getRawAxis(5)*0.5);
        
        if(m_stick.getRawAxis(3) > 0.3)
        {
            arm.set(m_stick.getRawAxis(3)*0.5);
        }
        else if(m_stick.getRawAxis(2) > 0.3)
        {
            arm.set(m_stick.getRawAxis(2) * -0.5);
        }
        else
        {
            arm.set(0);
        }
        
        if(m_stick.getRawButton(4))
        {
            claw.set(true);
        }
        else if(m_stick.getRawButton(1))
        {
            claw.set(false);
        }
 
        if(m_stick.getRawButton(2))
        {
          intake.set(1);
        }
        else if(m_stick.getRawButton(3))
        {
          intake.set(-1);
        }
        else
        {
          intake.set(0);
        }
        
    }
}

```


# [FRC Control System 2019](https://wpilib.screenstepslive.com/s/4485)
![](https://i.imgur.com/YBiq07X.png)
## [Hardware Overview](https://wpilib.screenstepslive.com/s/currentCS/m/cs_hardware/l/144968-frc-control-system-hardware-overview)
### [roboRio](http://www.ni.com/pdf/manuals/374474a.pdf)
![](https://i.imgur.com/8F0JHvu.png)
### [Power Distribution Panel](http://www.ctr-electronics.com/control-system/pdp.html#product_tabs_technical_resources)
![](https://i.imgur.com/HZzyN5y.png)
### [Pneumatics Control Module](http://www.ctr-electronics.com/control-system/pcm.html#product_tabs_technical_resources)
![](https://i.imgur.com/6qTJNBf.png)
[Wiring Pneumatics](https://wpilib.screenstepslive.com/s/currentCS/m/cs_hardware/l/290495-wiring-pneumatics)
### [Voltage Regulator Module](http://www.ctr-electronics.com/control-system/vrm.html#product_tabs_technical_resources)
![](https://i.imgur.com/JCrMw5W.png)
-  radio, custom circuits, and IP vision cameras
### Motor Controllers
#### [TalonSRX](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources)
![](https://i.imgur.com/rzPNVdb.png)
- encoder
- CAN device
- CAN Talon SRX has been removed from WPILib
- 3rd library
- [some code examples](https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages)
- [Phoenix Software](https://phoenix-documentation.readthedocs.io/en/latest/ch03_PrimerPhoenixSoft.html)
#### [VictorSP](https://www.vexrobotics.com/vexpro/motors-electronics/217-9090.html)
- **已停產**
- PWM
#### [VictorSPX](https://www.vexrobotics.com/217-9191.html)
![](https://i.imgur.com/7JzkJtD.png)
- 取代VictorSP
- 更便宜更小更厲害
- CAN or PWM
![](https://i.imgur.com/OerWmBr.png)

#### [SPARK Motor Controller](http://www.revrobotics.com/rev-11-1200/)
![](https://i.imgur.com/1bhn3oK.png)
- PWM interface
- Brake mode or Coast mode

### Breaker
![](https://i.imgur.com/XD6zz1j.png)
![](https://i.imgur.com/9v3c6Ea.png)
### Battery
![](https://i.imgur.com/5vBumm7.png)
## [Web Dashboard](https://wpilib.screenstepslive.com/s/currentCS/m/cs_hardware/l/262266-roborio-web-dashboard)
# [FRC Java Programming](https://wpilib.screenstepslive.com/s/currentCS/m/java)
![](https://i.imgur.com/BSr2Lqa.png)
## [Creating a robot program](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027062-creating-a-robot-program)
# Reference
## [method](https://www.tutorialspoint.com/java/java_methods.htm)

## [什麼是類別(Class)?](https://openhome.cc/Gossip/Java/Class.html)
- 物件導向設計中，物件並不是憑空產生的，您必須先定義您的物件，您要一個規格書，這個規格書稱之為類別（Class）。
- 在Java中使用"class"關鍵字來書寫類別（規格書），您使用類別來定義一個物件（object）時，您考慮這個物件可能擁有的「屬性」（Property，在Java中則是用Field）與「方法」（Method）。屬性是參與物件內部運算的資料成員，而方法則是物件與外界互動的動態操作。
- 您使用類別定義出物件的規格書，之後根據這個規格書來建構物件，然後透過物件所提供的操作介面來與程式互動。

```java=
class Vehicle {
    private int speed; // Object Variable
    private String direction; // Object Variable, direction is a reference to String Object
    private static int numVehicle = 0; // Class Variable
    public Vehicle() { // Constructor, called when new a Object
        this(0,"north"); // call another constructor to do initialization
    }//overload
    public Vehicle(int s, String dir) { // Another Constructor. Use overloading to define two constructors
        float speed; // define a local variable
        speed = s; // the speed here refers to the above local variable
        this.speed = s; // If we want to set object variable, use this.speed to refer object variable speed
        direction = dir; // dir is a reference to object, not the object itself
        numVehicle++;   // increase the Vehicle number
    }
    protected void finalize() { // Destructor, called when the object is garbage collected by JVM
        System.out.println("finalize has been called");
        numVehicle--;
    }
    void setSpeed(int newSpeed) { // Object Method
        this.speed = newSpeed;
    }
    void setDir(String dir) { // Object Method
        this.direction = dir;
    }
    int getSpeed() { // Object Method
        return speed;
    }
    String getDir() { // Object Method
        return direction;
    }
    public static int totalVehicle() { // Class Method
        return numVehicle;
    }
}
public class Example {
    public static void main(String[] argv) {
        Vehicle v1 = new Vehicle(50, "west"); // new 敘述用來產生物件. 物件產生時需要呼叫Constructor來初始化物件
        Vehicle v2;
        v1.setSpeed(30);
        v1.setDir("north");
        System.out.println("V1: speed is "+v1.getSpeed()+", direction is "+v1.getDir()+".\n");
        v2 = new Vehicle(40, "south");
        System.out.println("There are "+Vehicle.totalVehicle()+" Vehicles in the world.\n");
        v1 = v2; // let reference v1 point to where v2 is pointing
        System.out.println("V1: speed is "+v1.getSpeed()+", direction is "+v1.getDir()+".\n");
        System.gc(); // force system to do garbage collection, the object previously pointed by v1 shall be destroyed
        System.out.println("There are "+Vehicle.totalVehicle()+" Vehicles in the world.\n");
    }
}
```
- public:可用在class前面表示此class可以供其他package裡的類別使用。同一個目錄下的class均可視為屬於同一個package。
object or class member前面, 表示所有的class均可存取此member。
- private:可用在object or class member前面, 表示只有定義這些member的class才可存取。
- static:可用在member前面。如果member前面有static, 表示該member屬於class,否則屬於object。不論系統創造了多少object,class variable只有一個;而每個object都有其object variable。存取class method的語法是ClassName.classMethod();存取object method時,則必須以reference.objectMethod()來呼叫。在Object Method裡,可用this表示目前的物件。但在Class Method裡就不能存取object member了。
## [Package](https://openhome.cc/Gossip/Java/Package.html)
![](https://i.imgur.com/g8Zj1gM.png)
```java=
package cc.openhome;

public class Main {
    public static void main(String[] args) {
        cc.openhome.util.Console.writeLine("Hello World");
    }
}
```
1. 原始碼檔案要放置在與package所定義名稱階層相同的資料夾階層
2. package所定義名稱與class所定義名稱，會結合而成類別的完全吻合名稱（Fully qualified name）
3. 位元碼檔案要放置在與package所定義名稱階層相同的資料夾階層
4. 要在套件間可以直接使用的類別或方法（Method）必須宣告為public
## [Import](https://openhome.cc/Gossip/Java/Import.html)
```java=
package cc.openhome;

import cc.openhome.util.Console;

public class Main {
    public static void main(String[] args) {
        Console.writeLine("Hello World");
    }
}
```
## [break、continue](https://openhome.cc/Gossip/Java/Break-Continue.html)
- break與continue還可以配合標籤使用，例如本來break只會離開for迴圈，設定標籤與區塊，則可以離開整個區塊。
```java=
back : { 
    for(int i = 0; i < 10; i++) { 
        if(i == 9) { 
            System.out.println("break"); 
            break back; 
        } 
    } 
    System.out.println("test"); 
}
```

## [物件指定與相等性](https://openhome.cc/Gossip/Java/Reference.html)
```java=
BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.1");
System.out.println(a == b);        // 顯示false
System.out.println(a.equals(b));  // 顯示true
```
![](https://i.imgur.com/fPEEMBn.png)
- 程式中使用a == b，就是在問，a牌子綁的物件是否就是b牌子綁的物件？答案「不是」，也就是false的結果，程式中使用a.equals(b)，就是在問，a牌子綁的物件與b牌子綁的物件，實際上內含值是否相同，因為a與b綁的物件，內含值都是"0.1"代表的數值，答案「是」，也就是true的結果。

## [Static](https://openhome.cc/Gossip/Java/Static.html)
- 變數或函數從屬於類別(Class),不屬於物件(Object)
