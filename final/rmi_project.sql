CREATE DATABASE  IF NOT EXISTS `rmi_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rmi_project`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: rmi_project
-- ------------------------------------------------------
-- Server version	5.6.35

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
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `files` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file` blob NOT NULL,
  `user` varchar(45) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `user_idx` (`user`),
  KEY `p_id_idx` (`p_id`),
  CONSTRAINT `p_id` FOREIGN KEY (`p_id`) REFERENCES `project_members` (`project_id`) ON DELETE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `project_members` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (1,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\á\0tExif\0\0MM\0*\0\0\0\0\Z\0\0\0\0\0\0\0>\0\0\0\0\0\0\0F(\0\0\0\0\0\0\0‡i\0\0\0\0\0\0\0N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0\0\0\0\0\0* \0\0\0\0\0\0\04\0\0\0\0ÿ\í\08Photoshop 3.0\08BIM\0\0\0\0\0\08BIM%\0\0\0\0\0\ÔŒÙ\0²\é€	˜\ìøB~ÿ\â`ICC_PROFILE\0\0\0Pappl\0\0mntrRGB XYZ \â\0\0\0\0\0\"\07acspAPPL\0\0\0\0APPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-appl\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0P\0\0\0bdscm\0\0´\0\06cprt\0\0\ì\0\0\0#wtpt\0\0\0\0\0rXYZ\0\0$\0\0\0gXYZ\0\08\0\0\0bXYZ\0\0L\0\0\0rTRC\0\0`\0\0aarg\0\0l\0\0\0 vcgt\0\0Œ\0\0\00ndin\0\0¼\0\0\0>chad\0\0ü\0\0\0,mmod\0\0(\0\0\0(bTRC\0\0`\0\0gTRC\0\0`\0\0aabg\0\0l\0\0\0 aagg\0\0l\0\0\0 desc\0\0\0\0\0\0\0Display\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0mluc\0\0\0\0\0\0\0#\0\0\0hrHR\0\0\0\0\0´koKR\0\0\0\0\0\ÈnbNO\0\0\0\0\0\Ôid\0\0\0\0\0\0\0\æhuHU\0\0\0\0\0øcsCZ\0\0\0\0\0daDK\0\0\0\0\0\"ukUA\0\0\0\0\0>ar\0\0\0\0\0\0\0ZitIT\0\0\0\0\0nroRO\0\0\0\0\0‚nlNL\0\0\0\0\0”heIL\0\0\0\0\0ªesES\0\0\0\0\0‚fiFI\0\0\0\0\0ÀzhTW\0\0\0\0\0\ÐviVN\0\0\0\0\0\ÜskSK\0\0\0\0\0\êzhCN\0\0\0\0\0\ÐruRU\0\0\0$\0\0\0frFR\0\0\0\0\0$ms\0\0\0\0\0\0\0:hiIN\0\0\0\0\0LcaES\0\0\0\0\0^thTH\0\0\0\0\0vesXL\0\0\0\0\0‚deDE\0\0\0\0\0‚enUS\0\0\0\0\0’ptBR\0\0\0\0\0¤plPL\0\0\0\0\0¼elGR\0\0\0\"\0\0\ÎsvSE\0\0\0\0\0ðtrTR\0\0\0\0\0\0jaJP\0\0\0\0\0ptPT\0\0\0\0\0 \0L\0C\0D\0 \0u\0 \0b\0o\0j\0i\Î\ì·\ì\0 \0L\0C\0D\0F\0a\0r\0g\0e\0-\0L\0C\0D\0L\0C\0D\0 \0W\0a\0r\0n\0a\0S\0z\0\í\0n\0e\0s\0 \0L\0C\0D\0B\0a\0r\0e\0v\0n\0ý\0 \0L\0C\0D\0L\0C\0D\0-\0f\0a\0r\0v\0e\0s\0k\0\æ\0r\0m\Z>;L>@>289\0 \0L\0C\0D \0L\0C\0D\0 EDHF)\0L\0C\0D\0 \0c\0o\0l\0o\0r\0i\0L\0C\0D\0 \0c\0o\0l\0o\0r\0K\0l\0e\0u\0r\0e\0n\0-\0L\0C\0D \0L\0C\0D\0 \æ\Ñ\â\Õ\à\Ù\0V\0\ä\0r\0i\0-\0L\0C\0D_i‚r\0 \0L\0C\0D\0L\0C\0D\0 \0M\0\à\0u\0F\0a\0r\0e\0b\0n\0ý\0 \0L\0C\0D&25B=>9\0 \Z\0-48A?;59\0L\0C\0D\0 \0c\0o\0u\0l\0e\0u\0r\0W\0a\0r\0n\0a\0 \0L\0C\0D	0			@	(\0 \0L\0C\0D\0L\0C\0D\0 \0e\0n\0 \0c\0o\0l\0o\0r\0L\0C\0D\0 *5\0F\0a\0r\0b\0-\0L\0C\0D\0C\0o\0l\0o\0r\0 \0L\0C\0D\0L\0C\0D\0 \0C\0o\0l\0o\0r\0i\0d\0o\0K\0o\0l\0o\0r\0 \0L\0C\0Dˆ³\ÇÁ\É¼·\0 ¿¸\Ì½·\0 \0L\0C\0D\0F\0\ä\0r\0g\0-\0L\0C\0D\0R\0e\0n\0k\0l\0i\0 \0L\0C\0D0«0\é0ü\0L\0C\0D\0L\0C\0D\0 \0a\0 \0C\0o\0r\0e\0s\0\0text\0\0\0\0Copyright Apple Inc., 2018\0\0XYZ \0\0\0\0\0\0ó\0\0\0\0\ÊXYZ \0\0\0\0\0\0qÀ\0\09Š\0\0gXYZ \0\0\0\0\0\0a#\0\0¹\æ\0\0öXYZ \0\0\0\0\0\0#ò\0\0\0\0½\Ðcurv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\06\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0\0†\0‹\0\0•\0š\0Ÿ\0£\0¨\0­\0²\0·\0¼\0Á\0\Æ\0\Ë\0\Ð\0\Õ\0\Û\0\à\0\å\0\ë\0ð\0ö\0û\r%+28>ELRY`gnu|ƒ‹’š¡©±¹Á\É\Ñ\Ù\á\éòú&/8AKT]gqz„Ž˜¢¬¶Á\Ë\Õ\à\ëõ\0!-8COZfr~Š–¢®º\Ç\Ó\à\ìù -;HUcq~Œš¨¶\Ä\Ó\áðþ\r+:IXgw†–¦µ\Å\Õ\åö\'7HYj{Œ¯À\Ñ\ãõ+=Oat†™¬¿\Ò\åø2FZn‚–ª¾\Ò\çû		%	:	O	d	y		¤	º	\Ï	\å	û\n\n\'\n=\nT\nj\n\n˜\n®\n\Å\n\Ü\nó\"9Qi€˜°\È\áù*C\\uŽ§À\Ùó\r\r\r&\r@\rZ\rt\rŽ\r©\r\Ã\r\Þ\rø.Id›¶\Ò\î	%A^z–³\Ï\ì	&Ca~›¹\×õ1OmŒª\É\è&Ed„£\Ã\ã#Ccƒ¤\Å\å\'Ij‹­\Îð4Vx›½\à&Il²\ÖúAe‰®\Ò÷@eŠ¯\Õú Ek‘·\Ý\Z\Z*\ZQ\Zw\Zž\Z\Å\Z\ì;cŠ²\Ú*R{£\ÌõGp™\Ã\ì@j”¾\é>i”¿\ê  A l ˜ \Ä ð!!H!u!¡!\Î!û\"\'\"U\"‚\"¯\"\Ý#\n#8#f#”#\Â#ð$$M$|$«$\Ú%	%8%h%—%\Ç%÷&\'&W&‡&·&\è\'\'I\'z\'«\'\Ü(\r(?(q(¢(\Ô))8)k))\Ð**5*h*›*\Ï++6+i++\Ñ,,9,n,¢,\×--A-v-«-\á..L.‚.·.\î/$/Z/‘/\Ç/þ050l0¤0\Û11J1‚1º1ò2*2c2›2\Ô3\r3F33¸3ñ4+4e4ž4\Ø55M5‡5\Â5ý676r6®6\é7$7`7œ7\×88P8Œ8\È99B99¼9ù:6:t:²:\ï;-;k;ª;\è<\'<e<¤<\ã=\"=a=¡=\à> >`> >\à?!?a?¢?\â@#@d@¦@\çA)AjA¬A\îB0BrBµB÷C:C}CÀDDGDŠD\ÎEEUEšE\ÞF\"FgF«FðG5G{GÀHHKH‘H\×IIcI©IðJ7J}J\ÄKKSKšK\âL*LrLºMMJM“M\ÜN%NnN·O\0OIO“O\ÝP\'PqP»QQPQ›Q\æR1R|R\ÇSS_SªSöTBTT\ÛU(UuU\ÂVV\\V©V÷WDW’W\àX/X}X\ËY\ZYiY¸ZZVZ¦Zõ[E[•[\å\\5\\†\\\Ö]\']x]\É^\Z^l^½__a_³``W`ª`üaOa¢aõbIbœbðcCc—c\ëd@d”d\ée=e’e\çf=f’f\èg=g“g\éh?h–h\ìiCišiñjHjŸj÷kOk§kÿlWl¯mm`m¹nnkn\Äooxo\Ñp+p†p\àq:q•qðrKr¦ss]s¸ttpt\Ìu(u…u\áv>v›vøwVw³xxnx\Ìy*y‰y\çzFz¥{{c{\Â|!||\á}A}¡~~b~\Â#„\å€G€¨\nkÍ‚0‚’‚ôƒWƒº„„€„\ã…G…«††r†×‡;‡ŸˆˆiˆÎ‰3‰™‰þŠdŠÊ‹0‹–‹üŒcŒÊ1˜ÿŽfŽÎ6žnÖ‘?‘¨’’z’\ã“M“¶” ”Š”ô•_•É–4–Ÿ—\n—u—\à˜L˜¸™$™™üšhšÕ›B›¯œœ‰œ÷dÒž@ž®ŸŸ‹Ÿú i Ø¡G¡¶¢&¢–££v£\æ¤V¤Ç¥8¥©¦\Z¦‹¦ý§n§\à¨R¨Ä©7©©ªª««u«\é¬\\¬Ð­D­¸®-®¡¯¯‹°\0°u°\ê±`±Ö²K²Â³8³®´%´œµµŠ¶¶y¶ð·h·\à¸Y¸Ñ¹J¹Âº;ºµ».»§¼!¼›½½¾\n¾„¾ÿ¿z¿õÀpÀ\ìÁgÁ\ã\Â_\Â\Û\ÃX\Ã\Ô\ÄQ\Ä\Î\ÅK\Å\È\ÆF\Æ\Ã\ÇAÇ¿\È=È¼\É:É¹\Ê8Ê·\Ë6Ë¶\Ì5Ìµ\Í5Íµ\Î6Î¶\Ï7Ï¸\Ð9Ðº\Ñ<Ñ¾\Ò?\ÒÁ\ÓD\Ó\Æ\ÔI\Ô\Ë\ÕN\Õ\Ñ\ÖU\Ö\Ø\×\\\×\à\Ød\Ø\è\Ùl\Ùñ\Úv\ÚûÛ€\ÜÜŠ\ÝÝ–\ÞÞ¢\ß)ß¯\à6\à½\áD\á\Ì\âS\â\Û\ãc\ã\ë\äs\äü\å„\æ\r\æ–\ç\ç©\è2\è¼\éF\é\Ð\ê[\ê\å\ëp\ëû\ì†\í\íœ\î(\î´\ï@\ï\ÌðXð\åñrñÿòŒóó§ô4ô\ÂõPõ\Þömöû÷Šøø¨ù8ù\ÇúWú\çûwüü˜ý)ýºþKþ\Üÿmÿÿpara\0\0\0\0\0\0\0\0ff\0\0ò§\0\0\rY\0\0\Ð\0\0\n[vcgt\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ndin\0\0\0\0\0\0\06\0\0§@\0\0U€\0\0LÀ\0\0žÀ\0\0%€\0\0À\0\0P\0\0\0T@\033\033\033\0\0\0\0\0\0\0\0sf32\0\0\0\0\0r\0\0øÿÿó\0\0º\0\0ýrÿÿûÿÿý¤\0\0\Ù\0\0Àqmmod\0\0\0\0\0\0\0\0 )\0\0\0\0\Î\Ì\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÀ\0\04\0*\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñð$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rðbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Û\0C\0\n\n\n\n\n\n\n\n\nÿ\Û\0C	ÿ\Ý\0\0ÿ\Ú\0\0\0?\0ýv\Úi\ÔQ]‡\êESLŠ(¤ÿ\Ðýx¢Š+°ýP(¢”u \0\n]´\ê(ÿ\Ñý|À£Š+°ýP0(¢Š\0(¢Š\0ÿ\Òý|¢Š+°ýP(¢Š\0(¢Š\0ÿ\Ù','erikatorio',2),(2,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\á\0tExif\0\0MM\0*\0\0\0\0\Z\0\0\0\0\0\0\0>\0\0\0\0\0\0\0F(\0\0\0\0\0\0\0‡i\0\0\0\0\0\0\0N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0\0\0\0\0\0N \0\0\0\0\0\0\0L\0\0\0\0ÿ\í\08Photoshop 3.0\08BIM\0\0\0\0\0\08BIM%\0\0\0\0\0\ÔŒÙ\0²\é€	˜\ìøB~ÿ\â`ICC_PROFILE\0\0\0Pappl\0\0mntrRGB XYZ \â\0\0\0\0\0\"\07acspAPPL\0\0\0\0APPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ö\Ö\0\0\0\0\0\Ó-appl\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0P\0\0\0bdscm\0\0´\0\06cprt\0\0\ì\0\0\0#wtpt\0\0\0\0\0rXYZ\0\0$\0\0\0gXYZ\0\08\0\0\0bXYZ\0\0L\0\0\0rTRC\0\0`\0\0aarg\0\0l\0\0\0 vcgt\0\0Œ\0\0\00ndin\0\0¼\0\0\0>chad\0\0ü\0\0\0,mmod\0\0(\0\0\0(bTRC\0\0`\0\0gTRC\0\0`\0\0aabg\0\0l\0\0\0 aagg\0\0l\0\0\0 desc\0\0\0\0\0\0\0Display\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0mluc\0\0\0\0\0\0\0#\0\0\0hrHR\0\0\0\0\0´koKR\0\0\0\0\0\ÈnbNO\0\0\0\0\0\Ôid\0\0\0\0\0\0\0\æhuHU\0\0\0\0\0øcsCZ\0\0\0\0\0daDK\0\0\0\0\0\"ukUA\0\0\0\0\0>ar\0\0\0\0\0\0\0ZitIT\0\0\0\0\0nroRO\0\0\0\0\0‚nlNL\0\0\0\0\0”heIL\0\0\0\0\0ªesES\0\0\0\0\0‚fiFI\0\0\0\0\0ÀzhTW\0\0\0\0\0\ÐviVN\0\0\0\0\0\ÜskSK\0\0\0\0\0\êzhCN\0\0\0\0\0\ÐruRU\0\0\0$\0\0\0frFR\0\0\0\0\0$ms\0\0\0\0\0\0\0:hiIN\0\0\0\0\0LcaES\0\0\0\0\0^thTH\0\0\0\0\0vesXL\0\0\0\0\0‚deDE\0\0\0\0\0‚enUS\0\0\0\0\0’ptBR\0\0\0\0\0¤plPL\0\0\0\0\0¼elGR\0\0\0\"\0\0\ÎsvSE\0\0\0\0\0ðtrTR\0\0\0\0\0\0jaJP\0\0\0\0\0ptPT\0\0\0\0\0 \0L\0C\0D\0 \0u\0 \0b\0o\0j\0i\Î\ì·\ì\0 \0L\0C\0D\0F\0a\0r\0g\0e\0-\0L\0C\0D\0L\0C\0D\0 \0W\0a\0r\0n\0a\0S\0z\0\í\0n\0e\0s\0 \0L\0C\0D\0B\0a\0r\0e\0v\0n\0ý\0 \0L\0C\0D\0L\0C\0D\0-\0f\0a\0r\0v\0e\0s\0k\0\æ\0r\0m\Z>;L>@>289\0 \0L\0C\0D \0L\0C\0D\0 EDHF)\0L\0C\0D\0 \0c\0o\0l\0o\0r\0i\0L\0C\0D\0 \0c\0o\0l\0o\0r\0K\0l\0e\0u\0r\0e\0n\0-\0L\0C\0D \0L\0C\0D\0 \æ\Ñ\â\Õ\à\Ù\0V\0\ä\0r\0i\0-\0L\0C\0D_i‚r\0 \0L\0C\0D\0L\0C\0D\0 \0M\0\à\0u\0F\0a\0r\0e\0b\0n\0ý\0 \0L\0C\0D&25B=>9\0 \Z\0-48A?;59\0L\0C\0D\0 \0c\0o\0u\0l\0e\0u\0r\0W\0a\0r\0n\0a\0 \0L\0C\0D	0			@	(\0 \0L\0C\0D\0L\0C\0D\0 \0e\0n\0 \0c\0o\0l\0o\0r\0L\0C\0D\0 *5\0F\0a\0r\0b\0-\0L\0C\0D\0C\0o\0l\0o\0r\0 \0L\0C\0D\0L\0C\0D\0 \0C\0o\0l\0o\0r\0i\0d\0o\0K\0o\0l\0o\0r\0 \0L\0C\0Dˆ³\ÇÁ\É¼·\0 ¿¸\Ì½·\0 \0L\0C\0D\0F\0\ä\0r\0g\0-\0L\0C\0D\0R\0e\0n\0k\0l\0i\0 \0L\0C\0D0«0\é0ü\0L\0C\0D\0L\0C\0D\0 \0a\0 \0C\0o\0r\0e\0s\0\0text\0\0\0\0Copyright Apple Inc., 2018\0\0XYZ \0\0\0\0\0\0ó\0\0\0\0\ÊXYZ \0\0\0\0\0\0qÀ\0\09Š\0\0gXYZ \0\0\0\0\0\0a#\0\0¹\æ\0\0öXYZ \0\0\0\0\0\0#ò\0\0\0\0½\Ðcurv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\06\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0\0†\0‹\0\0•\0š\0Ÿ\0£\0¨\0­\0²\0·\0¼\0Á\0\Æ\0\Ë\0\Ð\0\Õ\0\Û\0\à\0\å\0\ë\0ð\0ö\0û\r%+28>ELRY`gnu|ƒ‹’š¡©±¹Á\É\Ñ\Ù\á\éòú&/8AKT]gqz„Ž˜¢¬¶Á\Ë\Õ\à\ëõ\0!-8COZfr~Š–¢®º\Ç\Ó\à\ìù -;HUcq~Œš¨¶\Ä\Ó\áðþ\r+:IXgw†–¦µ\Å\Õ\åö\'7HYj{Œ¯À\Ñ\ãõ+=Oat†™¬¿\Ò\åø2FZn‚–ª¾\Ò\çû		%	:	O	d	y		¤	º	\Ï	\å	û\n\n\'\n=\nT\nj\n\n˜\n®\n\Å\n\Ü\nó\"9Qi€˜°\È\áù*C\\uŽ§À\Ùó\r\r\r&\r@\rZ\rt\rŽ\r©\r\Ã\r\Þ\rø.Id›¶\Ò\î	%A^z–³\Ï\ì	&Ca~›¹\×õ1OmŒª\É\è&Ed„£\Ã\ã#Ccƒ¤\Å\å\'Ij‹­\Îð4Vx›½\à&Il²\ÖúAe‰®\Ò÷@eŠ¯\Õú Ek‘·\Ý\Z\Z*\ZQ\Zw\Zž\Z\Å\Z\ì;cŠ²\Ú*R{£\ÌõGp™\Ã\ì@j”¾\é>i”¿\ê  A l ˜ \Ä ð!!H!u!¡!\Î!û\"\'\"U\"‚\"¯\"\Ý#\n#8#f#”#\Â#ð$$M$|$«$\Ú%	%8%h%—%\Ç%÷&\'&W&‡&·&\è\'\'I\'z\'«\'\Ü(\r(?(q(¢(\Ô))8)k))\Ð**5*h*›*\Ï++6+i++\Ñ,,9,n,¢,\×--A-v-«-\á..L.‚.·.\î/$/Z/‘/\Ç/þ050l0¤0\Û11J1‚1º1ò2*2c2›2\Ô3\r3F33¸3ñ4+4e4ž4\Ø55M5‡5\Â5ý676r6®6\é7$7`7œ7\×88P8Œ8\È99B99¼9ù:6:t:²:\ï;-;k;ª;\è<\'<e<¤<\ã=\"=a=¡=\à> >`> >\à?!?a?¢?\â@#@d@¦@\çA)AjA¬A\îB0BrBµB÷C:C}CÀDDGDŠD\ÎEEUEšE\ÞF\"FgF«FðG5G{GÀHHKH‘H\×IIcI©IðJ7J}J\ÄKKSKšK\âL*LrLºMMJM“M\ÜN%NnN·O\0OIO“O\ÝP\'PqP»QQPQ›Q\æR1R|R\ÇSS_SªSöTBTT\ÛU(UuU\ÂVV\\V©V÷WDW’W\àX/X}X\ËY\ZYiY¸ZZVZ¦Zõ[E[•[\å\\5\\†\\\Ö]\']x]\É^\Z^l^½__a_³``W`ª`üaOa¢aõbIbœbðcCc—c\ëd@d”d\ée=e’e\çf=f’f\èg=g“g\éh?h–h\ìiCišiñjHjŸj÷kOk§kÿlWl¯mm`m¹nnkn\Äooxo\Ñp+p†p\àq:q•qðrKr¦ss]s¸ttpt\Ìu(u…u\áv>v›vøwVw³xxnx\Ìy*y‰y\çzFz¥{{c{\Â|!||\á}A}¡~~b~\Â#„\å€G€¨\nkÍ‚0‚’‚ôƒWƒº„„€„\ã…G…«††r†×‡;‡ŸˆˆiˆÎ‰3‰™‰þŠdŠÊ‹0‹–‹üŒcŒÊ1˜ÿŽfŽÎ6žnÖ‘?‘¨’’z’\ã“M“¶” ”Š”ô•_•É–4–Ÿ—\n—u—\à˜L˜¸™$™™üšhšÕ›B›¯œœ‰œ÷dÒž@ž®ŸŸ‹Ÿú i Ø¡G¡¶¢&¢–££v£\æ¤V¤Ç¥8¥©¦\Z¦‹¦ý§n§\à¨R¨Ä©7©©ªª««u«\é¬\\¬Ð­D­¸®-®¡¯¯‹°\0°u°\ê±`±Ö²K²Â³8³®´%´œµµŠ¶¶y¶ð·h·\à¸Y¸Ñ¹J¹Âº;ºµ».»§¼!¼›½½¾\n¾„¾ÿ¿z¿õÀpÀ\ìÁgÁ\ã\Â_\Â\Û\ÃX\Ã\Ô\ÄQ\Ä\Î\ÅK\Å\È\ÆF\Æ\Ã\ÇAÇ¿\È=È¼\É:É¹\Ê8Ê·\Ë6Ë¶\Ì5Ìµ\Í5Íµ\Î6Î¶\Ï7Ï¸\Ð9Ðº\Ñ<Ñ¾\Ò?\ÒÁ\ÓD\Ó\Æ\ÔI\Ô\Ë\ÕN\Õ\Ñ\ÖU\Ö\Ø\×\\\×\à\Ød\Ø\è\Ùl\Ùñ\Úv\ÚûÛ€\ÜÜŠ\ÝÝ–\ÞÞ¢\ß)ß¯\à6\à½\áD\á\Ì\âS\â\Û\ãc\ã\ë\äs\äü\å„\æ\r\æ–\ç\ç©\è2\è¼\éF\é\Ð\ê[\ê\å\ëp\ëû\ì†\í\íœ\î(\î´\ï@\ï\ÌðXð\åñrñÿòŒóó§ô4ô\ÂõPõ\Þömöû÷Šøø¨ù8ù\ÇúWú\çûwüü˜ý)ýºþKþ\Üÿmÿÿpara\0\0\0\0\0\0\0\0ff\0\0ò§\0\0\rY\0\0\Ð\0\0\n[vcgt\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ndin\0\0\0\0\0\0\06\0\0§@\0\0U€\0\0LÀ\0\0žÀ\0\0%€\0\0À\0\0P\0\0\0T@\033\033\033\0\0\0\0\0\0\0\0sf32\0\0\0\0\0r\0\0øÿÿó\0\0º\0\0ýrÿÿûÿÿý¤\0\0\Ù\0\0Àqmmod\0\0\0\0\0\0\0\0 )\0\0\0\0\Î\Ì\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿÀ\0\0L\0N\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñð$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rðbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Û\0C\0\n\n\n\n\n\n\n\n\nÿ\Û\0C	ÿ\Ý\0\0ÿ\Ú\0\0\0?\0üã¢Š+Õ¹\ÎQE \n(¢€\n(¢€\n(¢€?ÿ\Ðüã¢Šv\ÚõR9\Æ\ÑN\ÛF\Ú| 6Šv\Ú6\Ñ\Êh§m4\Ò¤\ÐQHÿ\Ñü\ä4újÓ«\×G8QI‘KN\àS	\Í%Jcu¤¢¡€QE€ÿ\Òüç¢Š+\Ø9\Æ´”ü\n0)4(§\àQK”QOÀ£ŽPE?™Rÿ\Óüç¢Š+\Ø9ÂŠ( Š( Š( €ih¤\Ðÿ\Ù','haileesteinfeld',3);
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_members`
--

DROP TABLE IF EXISTS `project_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_members` (
  `username` varchar(45) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`username`,`project_id`),
  KEY `project_id_idx` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_members`
--

LOCK TABLES `project_members` WRITE;
/*!40000 ALTER TABLE `project_members` DISABLE KEYS */;
INSERT INTO `project_members` VALUES ('erikatorio',1),('haileesteinfeld',2),('haileesteinfeld',3);
/*!40000 ALTER TABLE `project_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `proj_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'on-going',
  `leader` varchar(45) NOT NULL,
  PRIMARY KEY (`proj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Integ Lab','on-going','haileesteinfeld'),(2,'Webtech Lec','on-going','erikatorio'),(3,'Integ Lec','on-going','erikatorio'),(4,'OJT','completed','erikatorio');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin','admin','admin','active'),('erikatorio','Erika','Torio','erika','active'),('haileesteinfeld','Hailee','Steinfeld','hailee','active'),('kenancea','Kena','Cea','kenan','active');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'rmi_project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 15:47:16
