-- MySQL dump 10.13  Distrib 5.7.26, for macos10.14 (x86_64)
--
-- Host: 140.143.90.158    Database: test
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Administrator`
--

DROP TABLE IF EXISTS `Administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrator` (
  `id` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrator`
--

LOCK TABLES `Administrator` WRITE;
/*!40000 ALTER TABLE `Administrator` DISABLE KEYS */;
INSERT INTO `Administrator` VALUES ('d99419b05a79285cf613','2512275207@qq.com','184108','123'),('e2ffb51b6ec816661a21','951496671@qq.com','680478','123456');
/*!40000 ALTER TABLE `Administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Picofadministrator`
--

DROP TABLE IF EXISTS `Picofadministrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Picofadministrator` (
  `administratorId` varchar(50) NOT NULL,
  `adkey` varchar(100) NOT NULL,
  PRIMARY KEY (`administratorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Picofadministrator`
--

LOCK TABLES `Picofadministrator` WRITE;
/*!40000 ALTER TABLE `Picofadministrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `Picofadministrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appOfcom`
--

DROP TABLE IF EXISTS `appOfcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appOfcom` (
  `applicationId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appOfcom`
--

LOCK TABLES `appOfcom` WRITE;
/*!40000 ALTER TABLE `appOfcom` DISABLE KEYS */;
INSERT INTO `appOfcom` VALUES ('4edb09c9862a3fbbb985','4c952546560cccd4b915'),('52e5b3f681a19c5cd96a','435d2c45456235bd2b41'),('7e807be55b78a8a60152','63532325ee37bf82ee22'),('88ad318fa1903e4aa60a','78c2a6fa8835d6de9d76'),('8eb3750198c86637c39d','63532325ee37bf82ee22'),('97bdcd030456c934a11f','435d2c45456235bd2b41'),('98fb75efc65ccea11314','78c2a6fa8835d6de9d76'),('c66c232ae3bbc65aec5f','435d2c45456235bd2b41'),('cd4f5a8bd6e55b9fd57d','435d2c45456235bd2b41');
/*!40000 ALTER TABLE `appOfcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appOfuser`
--

DROP TABLE IF EXISTS `appOfuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appOfuser` (
  `applicationId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appOfuser`
--

LOCK TABLES `appOfuser` WRITE;
/*!40000 ALTER TABLE `appOfuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `appOfuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `applicationId` varchar(50) NOT NULL,
  `comName` varchar(50) NOT NULL,
  `companydesc` varchar(255) NOT NULL,
  `position` varchar(50) NOT NULL,
  `positiondesc` varchar(255) NOT NULL,
  `requirement` varchar(255) NOT NULL,
  `num` int(255) NOT NULL,
  `money` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tag` varchar(100) NOT NULL,
  `uptime` varchar(100) NOT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES ('4edb09c9862a3fbbb985','Tencent','腾讯 猛！','项目经理','111','1111',2,'15-20K','广东深圳','校园招聘','2020-06-24_09:54:39'),('52e5b3f681a19c5cd96a','1','1','1','1','1',1,'1k','1','1','2020-06-24_01:34:51'),('7e807be55b78a8a60152','成都科技','good','java开发岗','java开发','熟悉java',5,'12-15k','成都','校园招聘','2020-06-24_11:36:44'),('88ad318fa1903e4aa60a','四川省成都市','一所很优秀的大学','11111','11111111111','111111111111',11,'1111111111','11111111111','11111111111','2020-06-24_11:42:07'),('8eb3750198c86637c39d','江西省南昌市高新开发区艾溪湖一路正邦集团','计算机软硬件技术、电子信息技术、数据处理技术开发、转让、咨询、服务','15-25k·12薪','1、负责项目市场拓展、商务洽谈与合作、商机挖掘、项目衍生需求引入等事项。2、负责拓展物流、汽车等消费金融场景金融需求，设计开发相关金融产品。','1、全日制本科及以上学历；2、具备3年以上项目开发经验，2年以上项目管理经验；',2,'15-25k·12薪','高新区天府三街大源国际A3栋802','校园招聘','2020-06-24_09:58:04'),('97bdcd030456c934a11f','1','1','12','1','1',12,'1k','1','1555555','2020-06-24_01:58:55'),('98fb75efc65ccea11314','四川省成都市','一所很优秀的大学','老师','22222222','22222222222',3,'22222222222','222222222','22222222','2020-06-24_11:06:39'),('c66c232ae3bbc65aec5f','ALI','这是一个测试','zxc','zxczxc','zxczxc',3,'zxczxc','zxczxc','zxc','2020-06-24_09:53:21'),('cd4f5a8bd6e55b9fd57d','ALI','这是一个测试','BUG修复员','修改BUG','资深程序员',1,'巨高','西园22舍','太难了','2020-06-24_09:46:35');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applyment`
--

DROP TABLE IF EXISTS `applyment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applyment` (
  `user_id` varchar(50) NOT NULL,
  `applyment_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyment`
--

LOCK TABLES `applyment` WRITE;
/*!40000 ALTER TABLE `applyment` DISABLE KEYS */;
/*!40000 ALTER TABLE `applyment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkcode`
--

DROP TABLE IF EXISTS `checkcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkcode` (
  `id` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkcode`
--

LOCK TABLES `checkcode` WRITE;
/*!40000 ALTER TABLE `checkcode` DISABLE KEYS */;
INSERT INTO `checkcode` VALUES ('1029c7e80ccc01670060','866274'),('107f860d8804aaa46cf4','178563'),('10fde7d901656e1e656b','112590'),('128f3b48527dc0a74bcf','817725'),('15629f30eb27e7198eec','622550'),('18f8d7d9549357dd0e2e','135402'),('21996cb958b35f448ddf','647482'),('238d9a51a2dde09b7fab','376775'),('24869d086081b20f14fa','628809'),('25653ec050ace9ed88cf','624272'),('2ae490a8149ab06a5426','124700'),('2d8d41ac6f40ecf8b7a1','730790'),('395d770dbbe9c9ba0e32','560570'),('3f9466af2d3a48668f2d','805327'),('420ad064f4b6b9c49eda','772030'),('4e26667b29481a874cb9','680478'),('4ea41a8052ec3222fbfe','227290'),('523b1390856be45f6366','710408'),('56676975f4c50b40f2ef','184108'),('56ac8c0b372c796b5610','728255'),('5aa311e77aed08760750','523312'),('5adb0a2fa1369f21423b','645213'),('5c5a68f64ad95d737604','531270'),('5e4b4d4c51fbde45fa0f','373413'),('605588120ad469e2e467','645038'),('688d273fb35d077fb528','103361'),('6e1bff16aa4c53853e16','175366'),('724047198df9f1a164b0','040333'),('7392684a346e8737787f','242639'),('7e3acd8f37eb4a0fb554','131415'),('7eeec27c9545752701ea','928787'),('7fef9bd37453032d0fe0','438064'),('844f7980e31a03c37bd9','454260'),('97280ec4e4ffb0eab139','280172'),('9bf6c932350b9d1b1a29','244950'),('a1436dc09e521fc488da','174835'),('a2a2a8333160e25e6f61','229552'),('a57d09a46f6f4f92f0e5','396768'),('a980e0e8b5735e4dc459','389810'),('abb35300ba4232e3c922','465522'),('b066328857046a8d757b','910081'),('b8f00943bdbe16109d39','122285'),('bc0be3c4c7bf778402d6','506853'),('bc121bb654372bd5d75c','722510'),('c1af956475250b6f474c','708322'),('c6673108b0ba2bf979b3','253552'),('cfc04766da9285ac24c8','705176'),('d3ce817bc471cca3a321','322587'),('d862996dbd39910f488b','460146'),('da7f345a0eea2f22c1ea','325909'),('db2895a25eccd6124a81','941149'),('db84abe9f5787cd8174a','398981'),('dcaf9e2423e7412ac7bb','013186'),('e288383dce046167d875','263717'),('e3e04c99cff06f10ca99','673869'),('e44ae83945b348d7d614','545627'),('eb10d9c988dd2c9fef88','869067'),('ecc1af77d912b6ca488c','313796'),('ecfeeb1ca93431875b4d','982557'),('eec8f3b1e9b9d454fa0e','930181'),('f4608fc04da029f73832','614373'),('f4c7c150d6fef5097202','969834'),('fa81b290d5d8922e61f7','465354'),('fb16d1b2f8e1ec73bdd7','153397'),('fe28fce0c2d044863764','767629');
/*!40000 ALTER TABLE `checkcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comalreadyaccess`
--

DROP TABLE IF EXISTS `comalreadyaccess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comalreadyaccess` (
  `id` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  `applicationId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comalreadyaccess`
--

LOCK TABLES `comalreadyaccess` WRITE;
/*!40000 ALTER TABLE `comalreadyaccess` DISABLE KEYS */;
INSERT INTO `comalreadyaccess` VALUES ('1f37bf914dc7137e00dad549f7e709fd','6d978c71e299ede31dea','63532325ee37bf82ee22','8eb3750198c86637c39d'),('4e56a4acc12a77f50e35af7bcc8f5d','6c01bffe90723dee0fcb','435d2c45456235bd2b41','52e5b3f681a19c5cd96a'),('51e7d402a246ca17ebc66f72e2becc43','e640ae98f46add425c27','435d2c45456235bd2b41','52e5b3f681a19c5cd96a'),('5e98d8649556eb936fe0ec5dc1be36c1','b2c96d2f518ebe2926ef','4c952546560cccd4b915','4edb09c9862a3fbbb985'),('78e5fca3ba40bbc58701eb6be0e546eb','454f194d5f304aa90b0f','435d2c45456235bd2b41','52e5b3f681a19c5cd96a'),('d1d847502043ec9a235513bf3857512f','94543dad69df50e6edc8','435d2c45456235bd2b41','52e5b3f681a19c5cd96a');
/*!40000 ALTER TABLE `comalreadyaccess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cominfo`
--

DROP TABLE IF EXISTS `cominfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cominfo` (
  `id` varchar(50) NOT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `cominfoId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cominfo`
--

LOCK TABLES `cominfo` WRITE;
/*!40000 ALTER TABLE `cominfo` DISABLE KEYS */;
INSERT INTO `cominfo` VALUES ('182e56b1053b64856c968ef2b3b13f33','435d2c45456235bd2b41','15b157e8c0ab9c2af805490eff3349ab'),('49b212e8334cb14bc4478b02bbe1294b','4c952546560cccd4b915','e8356f73a84099cc5942967f253508d4'),('9ab60bcd7fc9ba72462f9c66837634d5','bf7e8c86b6c488aa9145','31f8f53ba11deae90f94121876321a18'),('b6fc462c639c833a080e5034f81d95b0','78c2a6fa8835d6de9d76','b56389d1193da603ea485a69562007b'),('de36315f281275c5abc0fa081aa14be6','63532325ee37bf82ee22','575744a15471d5d95aed5a7a0bb478ab');
/*!40000 ALTER TABLE `cominfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cominformation`
--

DROP TABLE IF EXISTS `cominformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cominformation` (
  `id` varchar(50) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `nature` varchar(50) NOT NULL,
  `comTime` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `web` varchar(255) NOT NULL,
  `mailbox` varchar(100) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cominformation`
--

LOCK TABLES `cominformation` WRITE;
/*!40000 ALTER TABLE `cominformation` DISABLE KEYS */;
INSERT INTO `cominformation` VALUES ('15b157e8c0ab9c2af805490eff3349ab','ALI','IT','new_setUpDate','这是一个测试','new_address','new_web','new_email','435d2c45456235bd2b41'),('31f8f53ba11deae90f94121876321a18','四川成都','食品加工类企业','1999.01.11','欢迎加入Wang','四川成都','www.wang.com','752634138@qq.com','bf7e8c86b6c488aa9145'),('575744a15471d5d95aed5a7a0bb478ab','江西省南昌市高新开发区艾溪湖一路正邦集团','互联网公司','2018年05月','计算机软硬件技术、电子信息技术、数据处理技术开发、转让、咨询、服务;计算机软硬件及辅助设备、办公自动化设备销售;数据处理与储存服务;商务信息咨询;企业管理咨询','江西省南昌市高新开发区艾溪湖一路正邦集团','https://zhengbangjitua.com','zhengbangjituan@firm.com','63532325ee37bf82ee22'),('b56389d1193da603ea485a69562007b','四川省成都市','教育机构','1900','一所很优秀的大学','四川省成都市','www.sichuan','2512275207@qq.com','78c2a6fa8835d6de9d76'),('e8356f73a84099cc5942967f253508d4','Tencent','互联网公司','1998.11.11','腾讯 猛！','中华人民共和国广东省深圳市','www.tencent.com','zjunlin0714@163.com','4c952546560cccd4b915');
/*!40000 ALTER TABLE `cominformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  `applicationId` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  `commenttime` varchar(100) NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('4d744f2b32de238e877e','816385a4148eb0d5e8f0','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','good','2020-06-24_01:35:33'),('79ea12edafa2a0b09d9f','ee92922f1be822022f11','4c952546560cccd4b915','4edb09c9862a3fbbb985','我真诚的求职','2020-06-24_09:57:13'),('7a2e6aacf69f5f736d85','f47cbf277a628f299ab6','63532325ee37bf82ee22','8eb3750198c86637c39d','要没学上了','2020-06-24_10:37:54');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comofemail`
--

DROP TABLE IF EXISTS `comofemail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comofemail` (
  `companyId` varchar(50) NOT NULL,
  `companyEmail` varchar(50) NOT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comofemail`
--

LOCK TABLES `comofemail` WRITE;
/*!40000 ALTER TABLE `comofemail` DISABLE KEYS */;
INSERT INTO `comofemail` VALUES ('435d2c45456235bd2b41','2017141471239@stu.scu.edu.cn'),('4c952546560cccd4b915','zjunlin0714@163.com'),('63532325ee37bf82ee22','1063356646@qq.com'),('78c2a6fa8835d6de9d76','2512275207@qq.com'),('98dceb66bc222f2fa34f','752634138@qq.com'),('bf7e8c86b6c488aa9145','wangxiaoye19990111@outlook.com');
/*!40000 ALTER TABLE `comofemail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` varchar(50) NOT NULL,
  `companyEmail` varchar(50) NOT NULL,
  `comName` varchar(50) NOT NULL,
  `comPassword` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('435d2c45456235bd2b41','2017141471239@stu.scu.edu.cn','531270','15968858321'),('4c952546560cccd4b915','zjunlin0714@163.com','389810','zjl1998'),('63532325ee37bf82ee22','1063356646@qq.com','545627','23282396'),('78c2a6fa8835d6de9d76','2512275207@qq.com','805327','123'),('98dceb66bc222f2fa34f','752634138@qq.com','866274','123456'),('bf7e8c86b6c488aa9145','wangxiaoye19990111@outlook.com','280172','0987654321');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `companyID` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES ('1131ddc13b564be77c03','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('14e64a5018452a1e2d66','ee92922f1be822022f11','63532325ee37bf82ee22','C2S'),('1528aefdeaf748adba5d','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('1bcb8ff739e4a11d3814','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('1eb3efce319718e013c5','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('25ad109f16d91f28b4ec','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('2e3792424c3e6d22eec2','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('303634fc7798d0caaad1','false','78c2a6fa8835d6de9d76','C2S'),('3c0727a5c9096b43c97b','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('3d531ad231d36e645287','ee92922f1be822022f11','78c2a6fa8835d6de9d76','C2S'),('41281475642f74fbd174','ee92922f1be822022f11','63532325ee37bf82ee22','C2S'),('44b44e3cedf9a7ed70fc','48d32526483363ff1a7b','78c2a6fa8835d6de9d76','C2S'),('45578abc81cd409c48c5','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('4583ab12431dfbbac659','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('497a10045c764924462d','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('4b223e538815b9e2c6a9','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('4c842f1f1af97bb49682','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('4d95ae50e5e48f0f042e','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('4f1b06257a5123a63c06','ee92922f1be822022f11','4c952546560cccd4b915','C2S'),('520d6c9c49e33c58c581','false','435d2c45456235bd2b41','C2S'),('52663250c6af374836e7','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('52de0c21341115e37adc','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('57718e8e94e0a4c9956a','f47cbf277a628f299ab6','78c2a6fa8835d6de9d76','C2S'),('5bab9d9a9a323cba32d0','f47cbf277a628f299ab6','63532325ee37bf82ee22','C2S'),('5d0c32168c31be131207','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('63e8b80a3633a40f3b4f','f47cbf277a628f299ab6','63532325ee37bf82ee22','C2S'),('6463913d67bf5cf5a9de','false','63532325ee37bf82ee22','C2S'),('649782d530fa34f38617','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('68aee2dce8bc3a9a083f','f47cbf277a628f299ab6','63532325ee37bf82ee22','C2S'),('691a4223d4eed5a04993','48d32526483363ff1a7b','4c952546560cccd4b915','C2S'),('73b972e3144f327d2bde','48d32526483363ff1a7b','4c952546560cccd4b915','C2S'),('765b6c0f45ffebd227e0','ee92922f1be822022f11','63532325ee37bf82ee22','C2S'),('7f71b12c1c4901c64372','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('7fa1ec19c76951cd24ea','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('8465b17f8d0b90328aac','f47cbf277a628f299ab6','78c2a6fa8835d6de9d76','C2S'),('8f855b792c76f9c50595','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('91acdb6b5ccc49b88f4c','false','78c2a6fa8835d6de9d76','C2S'),('92b92d2b61bfc9b5f60a','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('94bd39d4eaafc4ff3997','48d32526483363ff1a7b','4c952546560cccd4b915','C2S'),('9d0eb1e248fd11fb32a7','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('a3e4d2be38efbde7059e','ee92922f1be822022f11','4c952546560cccd4b915','C2S'),('a5146a8df8934ec737c3','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('ac5a467bc1e61216d9a2','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('ac96f871280dfaa7ec74','false','63532325ee37bf82ee22','C2S'),('b2e62a1e2bfa849e14dd','ee92922f1be822022f11','4c952546560cccd4b915','C2S'),('b8ec58da6e0a52c506d0','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('b9807dda8ef407de1fe7','false','63532325ee37bf82ee22','C2S'),('bd8b50f5cbab445b108b','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('c0ab4c2e141958f9d8ae','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('c788ae5f8fb80ff7c1ba','48d32526483363ff1a7b','78c2a6fa8835d6de9d76','C2S'),('c881f71f75f0bf71ca24','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('cbf66f545ff2a3ca6d86','f47cbf277a628f299ab6','63532325ee37bf82ee22','C2S'),('cdc8a93728495b77129f','false','63532325ee37bf82ee22','C2S'),('d0d693e4404cee107b1b','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('d34d47bf646441ef9248','f47cbf277a628f299ab6','63532325ee37bf82ee22','C2S'),('e15853d93899092948a9','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('e19317cf0f0bb0b26327','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('e7a5db691847f7432b07','false','78c2a6fa8835d6de9d76','C2S'),('effe4849e757913e17fd','ee92922f1be822022f11','4c952546560cccd4b915','C2S'),('f03df02da14dd122c39b','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('fd4e138f6e578f4e36ea','48d32526483363ff1a7b','435d2c45456235bd2b41','C2S'),('ff337cb6de94e4c8a647','ee92922f1be822022f11','435d2c45456235bd2b41','C2S');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `information`
--

DROP TABLE IF EXISTS `information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `information` (
  `id` varchar(50) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `realname` varchar(30) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `school` varchar(30) DEFAULT NULL,
  `education` varchar(50) NOT NULL,
  `professional` varchar(50) NOT NULL,
  `graduatetime` varchar(50) NOT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL,
  `workaddress` varchar(255) DEFAULT NULL,
  `userId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information`
--

LOCK TABLES `information` WRITE;
/*!40000 ALTER TABLE `information` DISABLE KEYS */;
INSERT INTO `information` VALUES ('6357da6b8e0c5b309deea42d85f00383','男','蔡光汉','1994-2-18','宁波大学','本科','网络空间安全','中级信息安全总监','3年金山信息维护工作经验','2017-6-1','宁波','ea0e0ab32050a20345fa'),('84290590f9ac835b165f1c76544ce1f1','男','曾俊霖','1998-07-14','四川大学','本科','软件工程','项目开发人员','暂无','2021.6.20','成都','ee92922f1be822022f11'),('90a8043aac8d04a34177f6f4c6cf002b','女','郑珂','1992-3-14','中国海洋大学','本科','软件工程','安卓开发工程师','2年阿里巴巴java后端开发','2015-6-1','杭州','752fa4da1d15e11df575'),('a9a2811d0c364402135922683f6d6499','男','许飞舟','1997-9-21','福建大学','本科','计算机科学与技术','web前端UI设计','字节跳动前端实习','2020-6-1','上海','71eae14c48e0b0591ec4'),('af7e0570f37ca557e7c2785e4cb96b3e','男','张旭橙','1998-10-20','四川大学','本科','软件工程','码农','阿里巴巴总裁','2021-07-01','成都','48d32526483363ff1a7b'),('b439f3d5f7d9fa39188d292db4db88a2','男','陈近之','1998-9-20','江苏大学','本科','软件工程','java后端开发','2年华为外派工作，积累了丰厚的实际项目经验。非常擅长后端开发,前端','2021-6-1','合肥','f47cbf277a628f299ab6');
/*!40000 ALTER TABLE `information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picOfapp`
--

DROP TABLE IF EXISTS `picOfapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picOfapp` (
  `applicationId` varchar(50) NOT NULL,
  `appkey` varchar(50) NOT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picOfapp`
--

LOCK TABLES `picOfapp` WRITE;
/*!40000 ALTER TABLE `picOfapp` DISABLE KEYS */;
/*!40000 ALTER TABLE `picOfapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picOfcom`
--

DROP TABLE IF EXISTS `picOfcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picOfcom` (
  `companyId` varchar(50) NOT NULL,
  `picOfkey` varchar(50) NOT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picOfcom`
--

LOCK TABLES `picOfcom` WRITE;
/*!40000 ALTER TABLE `picOfcom` DISABLE KEYS */;
INSERT INTO `picOfcom` VALUES ('4c952546560cccd4b915','d963-2020-06-24_02:54:18.pptx');
/*!40000 ALTER TABLE `picOfcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picUser`
--

DROP TABLE IF EXISTS `picUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picUser` (
  `userId` varchar(50) NOT NULL,
  `pickey` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picUser`
--

LOCK TABLES `picUser` WRITE;
/*!40000 ALTER TABLE `picUser` DISABLE KEYS */;
INSERT INTO `picUser` VALUES ('48d32526483363ff1a7b','1824-2020-06-24_09:54:58.png'),('752fa4da1d15e11df575','c86f-2020-06-24_03:44:29.pptx');
/*!40000 ALTER TABLE `picUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `resumeId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `retime` varchar(100) NOT NULL,
  `rekey` varchar(100) NOT NULL,
  PRIMARY KEY (`resumeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumeOfthree`
--

DROP TABLE IF EXISTS `resumeOfthree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resumeOfthree` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  `applicationId` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `threekey` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumeOfthree`
--

LOCK TABLES `resumeOfthree` WRITE;
/*!40000 ALTER TABLE `resumeOfthree` DISABLE KEYS */;
INSERT INTO `resumeOfthree` VALUES ('202120ec138c3a2d51f9','ee92922f1be822022f11','63532325ee37bf82ee22','8eb3750198c86637c39d','8bf96992e52070d9cefe','d89b-2020-06-24_11:30:49.pdf'),('2341d40757d8aa6344e7','71eae14c48e0b0591ec4','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','5d8ff079b63bd8cfdb2e','b8e6-2020-06-24_03:02:02.xls'),('29439e3a19f79450ff51','ee92922f1be822022f11','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','fe875e51a64f8c9929e3','2ad4-2020-06-24_02:59:56.jpg'),('3b77881d0653d2bc6658','ee92922f1be822022f11','63532325ee37bf82ee22','8eb3750198c86637c39d','26780a12158527b0fbd9','d964-2020-06-24_11:30:50.pdf'),('57832f1ae13d9de80f10','752fa4da1d15e11df575','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','e640ae98f46add425c27','67fd-2020-06-24_03:13:24.png'),('7536abd4e38b46adec7d','752fa4da1d15e11df575','63532325ee37bf82ee22','8eb3750198c86637c39d','6d978c71e299ede31dea','b222-2020-06-24_11:52:02.xls'),('8c13d4663f3479c83e64','ee92922f1be822022f11','63532325ee37bf82ee22','8eb3750198c86637c39d','fe616fa3816b45dedd9f','7ac6-2020-06-24_11:30:50.pdf'),('9df65383ac745a392207','ee92922f1be822022f11','63532325ee37bf82ee22','8eb3750198c86637c39d','e076117e46aee3c30b3f','f954-2020-06-24_11:30:50.pdf'),('a8f7d7cc77c7083074cd','ea0e0ab32050a20345fa','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','454f194d5f304aa90b0f','dac7-2020-06-24_03:16:18.java'),('ae98e0b40eb80c7198ae','d4af2c8db55805cb49aa','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','94543dad69df50e6edc8','f01f-2020-06-24_03:09:15.xls'),('b61866203c70f69ac4b1','816385a4148eb0d5e8f0','435d2c45456235bd2b41','97bdcd030456c934a11f','9ef83d3d35a5f6890258','2e9b-2020-06-24_02:46:39.java'),('d312df31458810ce6f5d','48d32526483363ff1a7b','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','6c01bffe90723dee0fcb','5fae-2020-06-24_01:58:58.docx'),('dacb7415401e95fce427','f47cbf277a628f299ab6','435d2c45456235bd2b41','97bdcd030456c934a11f','c387bdd8ba258861d5bf','2c09-2020-06-24_03:26:06.java'),('eeceae2e33b71779c550','48d32526483363ff1a7b','78c2a6fa8835d6de9d76','98fb75efc65ccea11314','aeac0cb33c60d0a077f1','f049-2020-06-24_11:18:00.docx'),('ff19f8cb9f45404d1c8f','ee92922f1be822022f11','4c952546560cccd4b915','4edb09c9862a3fbbb985','b2c96d2f518ebe2926ef','edad-2020-06-24_11:33:08.pptx');
/*!40000 ALTER TABLE `resumeOfthree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumeOfuser`
--

DROP TABLE IF EXISTS `resumeOfuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resumeOfuser` (
  `resumeId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  PRIMARY KEY (`resumeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumeOfuser`
--

LOCK TABLES `resumeOfuser` WRITE;
/*!40000 ALTER TABLE `resumeOfuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `resumeOfuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saveresumeAccess`
--

DROP TABLE IF EXISTS `saveresumeAccess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saveresumeAccess` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  `applicationId` varchar(50) NOT NULL,
  `sendtime` varchar(100) NOT NULL,
  `sendkey` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saveresumeAccess`
--

LOCK TABLES `saveresumeAccess` WRITE;
/*!40000 ALTER TABLE `saveresumeAccess` DISABLE KEYS */;
/*!40000 ALTER TABLE `saveresumeAccess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendresume`
--

DROP TABLE IF EXISTS `sendresume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendresume` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `companyId` varchar(50) NOT NULL,
  `applicationId` varchar(50) NOT NULL,
  `sendtime` varchar(100) NOT NULL,
  `sendkey` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendresume`
--

LOCK TABLES `sendresume` WRITE;
/*!40000 ALTER TABLE `sendresume` DISABLE KEYS */;
INSERT INTO `sendresume` VALUES ('26780a12158527b0fbd9','ee92922f1be822022f11','26780a12158527b0fbd9','63532325ee37bf82ee22','8eb3750198c86637c39d','2020-06-24_11:30:50','d964-2020-06-24_11:30:50.pdf'),('8bf96992e52070d9cefe','ee92922f1be822022f11','8bf96992e52070d9cefe','63532325ee37bf82ee22','8eb3750198c86637c39d','2020-06-24_11:30:49','d89b-2020-06-24_11:30:49.pdf'),('9ef83d3d35a5f6890258','816385a4148eb0d5e8f0','9ef83d3d35a5f6890258','435d2c45456235bd2b41','97bdcd030456c934a11f','2020-06-24_02:46:39','2e9b-2020-06-24_02:46:39.java'),('aeac0cb33c60d0a077f1','48d32526483363ff1a7b','aeac0cb33c60d0a077f1','78c2a6fa8835d6de9d76','98fb75efc65ccea11314','2020-06-24_11:18:00','f049-2020-06-24_11:18:00.docx'),('c387bdd8ba258861d5bf','f47cbf277a628f299ab6','c387bdd8ba258861d5bf','435d2c45456235bd2b41','97bdcd030456c934a11f','2020-06-24_03:26:07','2c09-2020-06-24_03:26:06.java'),('c543a2136c242d179538','71eae14c48e0b0591ec4','5d8ff079b63bd8cfdb2e','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','2020-06-24_03:02:03','b8e6-2020-06-24_03:02:02.xls'),('e076117e46aee3c30b3f','ee92922f1be822022f11','e076117e46aee3c30b3f','63532325ee37bf82ee22','8eb3750198c86637c39d','2020-06-24_11:30:50','f954-2020-06-24_11:30:50.pdf'),('fe616fa3816b45dedd9f','ee92922f1be822022f11','fe616fa3816b45dedd9f','63532325ee37bf82ee22','8eb3750198c86637c39d','2020-06-24_11:30:50','7ac6-2020-06-24_11:30:50.pdf'),('fe875e51a64f8c9929e3','ee92922f1be822022f11','fe875e51a64f8c9929e3','435d2c45456235bd2b41','52e5b3f681a19c5cd96a','2020-06-24_02:59:57','2ad4-2020-06-24_02:59:56.jpg');
/*!40000 ALTER TABLE `sendresume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('48d32526483363ff1a7b','951496671@qq.com','153397','123456'),('71eae14c48e0b0591ec4','nelsonchenscu@foxmail.com','124700','1063356646'),('752fa4da1d15e11df575','nelsonchenscu@gmail.com','398981','czytest'),('816385a4148eb0d5e8f0','1563180669@qq.com','263717','wsw'),('d4af2c8db55805cb49aa','2512275207@qq.com','244950','12345678'),('ea0e0ab32050a20345fa','2017141471239@stu.scu.edu.cn','523312','czy'),('ee92922f1be822022f11','zjunlin0714@163.com','928787','zjl1998'),('f47cbf277a628f299ab6','1063356646@qq.com','465522','23282396');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userAccessyes`
--

DROP TABLE IF EXISTS `userAccessyes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userAccessyes` (
  `id` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userAccessyes`
--

LOCK TABLES `userAccessyes` WRITE;
/*!40000 ALTER TABLE `userAccessyes` DISABLE KEYS */;
INSERT INTO `userAccessyes` VALUES ('46ca7168aaf325dc4bb4d77ab103cf92','6c01bffe90723dee0fcb','48d32526483363ff1a7b'),('540b0103a42d1615ffc0fd68d32273a5','6c01bffe90723dee0fcb','48d32526483363ff1a7b'),('55c7ad6955309a8b75a7da7e6ffb38bb','e640ae98f46add425c27','752fa4da1d15e11df575'),('6461cd77d8e5d66d40d6f896ea651cc0','454f194d5f304aa90b0f','ea0e0ab32050a20345fa'),('89109786dd4fba4ca0e028a6ecb525e5','454f194d5f304aa90b0f','ea0e0ab32050a20345fa'),('a1024a3b25319062c6f1361f1b1d971','454f194d5f304aa90b0f','ea0e0ab32050a20345fa'),('c555523bac6deb200605515fca9334a2','b2c96d2f518ebe2926ef','ee92922f1be822022f11'),('c7e509a03deafb3815e4caad4ab9024c','454f194d5f304aa90b0f','ea0e0ab32050a20345fa'),('ddcf33292a7fb7670f19448d716f229f','454f194d5f304aa90b0f','ea0e0ab32050a20345fa'),('ddd2fa5957eb8697e06e882d4d84dccf','454f194d5f304aa90b0f','ea0e0ab32050a20345fa');
/*!40000 ALTER TABLE `userAccessyes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useralreadyAccess`
--

DROP TABLE IF EXISTS `useralreadyAccess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useralreadyAccess` (
  `id` varchar(50) NOT NULL,
  `resumeId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useralreadyAccess`
--

LOCK TABLES `useralreadyAccess` WRITE;
/*!40000 ALTER TABLE `useralreadyAccess` DISABLE KEYS */;
INSERT INTO `useralreadyAccess` VALUES ('5bb9b28c6f875a2574048399869ae7e0','6d978c71e299ede31dea','752fa4da1d15e11df575'),('d6c834d2ada08b804b8d27d8c424954c','94543dad69df50e6edc8','d4af2c8db55805cb49aa');
/*!40000 ALTER TABLE `useralreadyAccess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `infoId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('13ef58268c13d4f873facd969d6069b9','752fa4da1d15e11df575','90a8043aac8d04a34177f6f4c6cf002b'),('408ae14a393737dada393b077fadfb9b','48d32526483363ff1a7b','af7e0570f37ca557e7c2785e4cb96b3e'),('4dcca8a29eac689a6d3d9031d70da6b8','ea0e0ab32050a20345fa','6357da6b8e0c5b309deea42d85f00383'),('57654afd4b193cf23aa2c807d3f50fad','ee92922f1be822022f11','84290590f9ac835b165f1c76544ce1f1'),('8a98b933cb3667c91e693f4752851fee','71eae14c48e0b0591ec4','a9a2811d0c364402135922683f6d6499'),('b9f25c3c148b3bc956ce3e5b85f64590','f47cbf277a628f299ab6','b439f3d5f7d9fa39188d292db4db88a2');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userofemail`
--

DROP TABLE IF EXISTS `userofemail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userofemail` (
  `userId` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userofemail`
--

LOCK TABLES `userofemail` WRITE;
/*!40000 ALTER TABLE `userofemail` DISABLE KEYS */;
INSERT INTO `userofemail` VALUES ('48d32526483363ff1a7b','951496671@qq.com'),('71eae14c48e0b0591ec4','nelsonchenscu@foxmail.com'),('752fa4da1d15e11df575','nelsonchenscu@gmail.com'),('816385a4148eb0d5e8f0','1563180669@qq.com'),('d4af2c8db55805cb49aa','2512275207@qq.com'),('ea0e0ab32050a20345fa','2017141471239@stu.scu.edu.cn'),('ee92922f1be822022f11','zjunlin0714@163.com'),('f47cbf277a628f299ab6','1063356646@qq.com');
/*!40000 ALTER TABLE `userofemail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-24 12:41:47
