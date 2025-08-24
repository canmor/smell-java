以下是整理成 Markdown 格式的 PRD 文档，适合直接放入项目中的 /docs/PRD.md 或用于团队共享：

# 📄 产品需求文档（PRD）：Refactor Java 网站

## 一、项目概述

**项目名称**：Refactor Java  
**目标用户**：学习 Java 的开发者、代码审查者、技术团队成员  
**核心目的**：帮助用户理解并识别《重构：改善既有代码的设计》一书中的典型“坏味道”，并通过 Java 示例和测验提升识别能力。

---

## 二、功能模块

### 1️⃣ 坏味道说明页面（Bad Smell Reference）

#### 功能描述

展示每种“坏味道”的中英文名称、分类、简要说明及一个 Java 示例。按类别组织如下：

#### 坏味道完整列表（共五类 22 项）

##### 🧱 Bloaters（膨胀味道）

- Long Method / 过长函数  
- Large Class / 过大的类  
- Primitive Obsession / 基本类型偏执  
- Long Parameter List / 过长参数列表  
- Data Clumps / 数据泥团  

##### 🧩 Object-Orientation Abusers（面向对象滥用）

- Repeated Switches / 重复的 switch  
- Temporary Field / 临时字段  
- Refused Bequest / 被拒绝的遗赠  
- Alternative Classes with Different Interfaces / 不同接口的相似类  

##### 🛑 Change Preventers（变更抑制器）

- Divergent Change / 发散式变化  
- Shotgun Surgery / 霰弹式修改  
- Parallel Inheritance Hierarchies / 平行继承体系  

##### 🧹 Dispensables（可清除对象）

- Comments / 多余注释  
- Duplicate Code / 重复代码  
- Lazy Class / 懒惰类  
- Data Class / 纯数据类  
- Dead Code / 死代码  
- Speculative Generality / 夸夸其谈通用性  

##### 🔗 Couplers（过度耦合）

- Feature Envy / 依恋情结  
- Inappropriate Intimacy / 不适当的亲密关系  
- Message Chains / 过长的消息链  
- Middle Man / 中间人  

#### 每种坏味道的内容结构（Markdown）

```markdown
---
name: "Long Method / 过长函数"
category: "Bloaters"
---

### 简介

函数代码过长，难以阅读和维护。通常是多个职责未拆分的迹象。

### 示例（Java）

```java
int calculateScore(Player p) {
    int score = 0;
    // 冗长处理逻辑
    return score;
}

---

### 2️⃣ 坏味道识别测验（Quiz）

#### 功能描述

- 每次测验随机呈现 Java 坏味道代码片段
- 每题 4 个选项，用户选择哪种“坏味道”
- 答案立即反馈，自动跳转下一题
- 最终统计总耗时与正确题数

#### 数据结构

- 每题为一个 JSON 文件，引用一个独立的 Java 示例文件

##### 示例 JSON (`quiz001.json`)

```json
{
  "id": "quiz001",
  "codePath": "snippets/quiz001.java",
  "correct": "Repeated Switches / 重复的 switch",
  "choices": [
    "Long Method / 过长函数",
    "Repeated Switches / 重复的 switch",
    "Data Clumps / 数据泥团",
    "Speculative Generality / 夸夸其谈通用性"
  ]
}

示例代码文件 (quiz001.java)

public int handle(int code) {
    if (code == 1) doA();
    else if (code == 2) doB();
    else if (code == 3) doC();
    return 0;
}


⸻

三、技术架构与页面生成

技术栈
	•	框架：Next.js（静态站点生成 SSG）
	•	UI 组件库：shadcn/ui
	•	样式系统：Tailwind CSS
	•	代码高亮：rehype-prism 或 Shiki
	•	语言：TypeScript

数据与项目结构建议

/data
  /bad-smells
    long-method.md
    ...
  /quiz
    quiz001.json
    ...
  /snippets
    quiz001.java
    ...

在 Next.js 的 getStaticProps 中读取 JSON 元数据，并同时加载对应 codePath 文件内容。

⸻

四、页面结构

/bad-smells
	•	类别标签导航
	•	每种坏味道卡片展示：名称、分类、摘要

/bad-smells/[slug]
	•	显示中英文名称、分类
	•	Markdown 渲染正文（含简介 + Java 示例）

/quiz
	•	显示测验题目编号、代码片段、选项按钮
	•	回答后立即反馈是否正确
	•	所有题目答完后展示：总题数、正确数、总耗时

⸻

六、交互要求（摘要）

功能点	要求说明
测验交互	每答一题立即反馈并切换下一题
答题结束	展示统计面板，含耗时与得分
代码显示	支持语法高亮，兼容移动设备
页面导航	提供清晰的分类浏览与返回路径