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
INSERT INTO `files` VALUES (1,'�\��\�\0JFIF\0\0\0�\0�\0\0�\�\0tExif\0\0MM\0*\0\0\0\0\Z\0\0\0\0\0\0\0>\0\0\0\0\0\0\0F(\0\0\0\0\0\0\0�i\0\0\0\0\0\0\0N\0\0\0\0\0\0\0�\0\0\0\0\0\0�\0\0\0\0�\0\0\0\0\0\0\0*�\0\0\0\0\0\0\04\0\0\0\0�\�\08Photoshop 3.0\08BIM\0\0\0\0\0\08BIM%\0\0\0\0\0\��ُ\0�\�	�\��B~�\�`ICC_PROFILE\0\0\0Pappl\0\0mntrRGB XYZ \�\0\0\0\0\0\"\07acspAPPL\0\0\0\0APPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\�-appl\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0P\0\0\0bdscm\0\0�\0\06cprt\0\0\�\0\0\0#wtpt\0\0\0\0\0rXYZ\0\0$\0\0\0gXYZ\0\08\0\0\0bXYZ\0\0L\0\0\0rTRC\0\0`\0\0aarg\0\0l\0\0\0 vcgt\0\0�\0\0\00ndin\0\0�\0\0\0>chad\0\0�\0\0\0,mmod\0\0(\0\0\0(bTRC\0\0`\0\0gTRC\0\0`\0\0aabg\0\0l\0\0\0 aagg\0\0l\0\0\0 desc\0\0\0\0\0\0\0Display\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0mluc\0\0\0\0\0\0\0#\0\0\0hrHR\0\0\0\0\0�koKR\0\0\0\0\0\�nbNO\0\0\0\0\0\�id\0\0\0\0\0\0\0\�huHU\0\0\0\0\0�csCZ\0\0\0\0\0daDK\0\0\0\0\0\"ukUA\0\0\0\0\0>ar\0\0\0\0\0\0\0ZitIT\0\0\0\0\0nroRO\0\0\0\0\0�nlNL\0\0\0\0\0�heIL\0\0\0\0\0�esES\0\0\0\0\0�fiFI\0\0\0\0\0�zhTW\0\0\0\0\0\�viVN\0\0\0\0\0\�skSK\0\0\0\0\0\�zhCN\0\0\0\0\0\�ruRU\0\0\0$\0\0\0frFR\0\0\0\0\0$ms\0\0\0\0\0\0\0:hiIN\0\0\0\0\0LcaES\0\0\0\0\0^thTH\0\0\0\0\0vesXL\0\0\0\0\0�deDE\0\0\0\0\0�enUS\0\0\0\0\0�ptBR\0\0\0\0\0�plPL\0\0\0\0\0�elGR\0\0\0\"\0\0\�svSE\0\0\0\0\0�trTR\0\0\0\0\0\0jaJP\0\0\0\0\0ptPT\0\0\0\0\0 \0L\0C\0D\0 \0u\0 \0b\0o\0j\0i\�\�\�\0 \0L\0C\0D\0F\0a\0r\0g\0e\0-\0L\0C\0D\0L\0C\0D\0 \0W\0a\0r\0n\0a\0S\0z\0\�\0n\0e\0s\0 \0L\0C\0D\0B\0a\0r\0e\0v\0n\0�\0 \0L\0C\0D\0L\0C\0D\0-\0f\0a\0r\0v\0e\0s\0k\0\�\0r\0m\Z>;L>@>289\0 \0L\0C\0D \0L\0C\0D\0 EDHF)\0L\0C\0D\0 \0c\0o\0l\0o\0r\0i\0L\0C\0D\0 \0c\0o\0l\0o\0r\0K\0l\0e\0u\0r\0e\0n\0-\0L\0C\0D \0L\0C\0D\0 \�\�\�\�\�\�\0V\0\�\0r\0i\0-\0L\0C\0D_i�r\0 \0L\0C\0D\0L\0C\0D\0 \0M\0\�\0u\0F\0a\0r\0e\0b\0n\0�\0 \0L\0C\0D&25B=>9\0 \Z\0-48A?;59\0L\0C\0D\0 \0c\0o\0u\0l\0e\0u\0r\0W\0a\0r\0n\0a\0 \0L\0C\0D	0			@	(\0 \0L\0C\0D\0L\0C\0D\0 \0e\0n\0 \0c\0o\0l\0o\0r\0L\0C\0D\0 *5\0F\0a\0r\0b\0-\0L\0C\0D\0C\0o\0l\0o\0r\0 \0L\0C\0D\0L\0C\0D\0 \0C\0o\0l\0o\0r\0i\0d\0o\0K\0o\0l\0o\0r\0 \0L\0C\0D��\��\���\0 ��\���\0 \0L\0C\0D\0F\0\�\0r\0g\0-\0L\0C\0D\0R\0e\0n\0k\0l\0i\0 \0L\0C\0D0�0\�0�\0L\0C\0D\0L\0C\0D\0 \0a\0 \0C\0o\0r\0e\0s\0\0text\0\0\0\0Copyright Apple Inc., 2018\0\0XYZ \0\0\0\0\0\0�\0\0\0\0\�XYZ \0\0\0\0\0\0q�\0\09�\0\0gXYZ \0\0\0\0\0\0a#\0\0�\�\0\0�XYZ \0\0\0\0\0\0#�\0\0�\0\0�\�curv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\06\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0\�\0\�\0\�\0\�\0\�\0\�\0\�\0\�\0�\0�\0�\r%+28>ELRY`gnu|���������\�\�\�\�\���&/8AKT]gqz�������\�\�\�\��\0!-8COZfr~�����\�\�\�\�� -;HUcq~����\�\�\���\r+:IXgw����\�\�\��\'7HYj{����\�\��+=Oat����\�\��2FZn����\�\��		%	:	O	d	y	�	�	�	\�	\�	�\n\n\'\n=\nT\nj\n�\n�\n�\n\�\n\�\n�\"9Qi���\�\��*C\\u���\��\r\r\r&\r@\rZ\rt\r�\r�\r\�\r\�\r�.Id��\�\�	%A^z��\�\�	&Ca~��\��1Om��\�\�&Ed��\�\�#Cc��\�\�\'Ij��\��4Vx��\�&Il��\��Ae��\��@e��\�� Ek��\�\Z\Z*\ZQ\Zw\Z�\Z\�\Z\�;c��\�*R{�\��Gp�\�\�@j��\�>i��\�  A l � \� �!!H!u!�!\�!�\"\'\"U\"�\"�\"\�#\n#8#f#�#\�#�$$M$|$�$\�%	%8%h%�%\�%�&\'&W&�&�&\�\'\'I\'z\'�\'\�(\r(?(q(�(\�))8)k)�)\�**5*h*�*\�++6+i+�+\�,,9,n,�,\�--A-v-�-\�..L.�.�.\�/$/Z/�/\�/�050l0�0\�11J1�1�1�2*2c2�2\�3\r3F33�3�4+4e4�4\�55M5�5\�5�676r6�6\�7$7`7�7\�88P8�8\�99B99�9�:6:t:�:\�;-;k;�;\�<\'<e<�<\�=\"=a=�=\�> >`>�>\�?!?a?�?\�@#@d@�@\�A)AjA�A\�B0BrB�B�C:C}C�DDGD�D\�EEUE�E\�F\"FgF�F�G5G{G�HHKH�H\�IIcI�I�J7J}J\�KKSK�K\�L*LrL�MMJM�M\�N%NnN�O\0OIO�O\�P\'PqP�QQPQ�Q\�R1R|R\�SS_S�S�TBT�T\�U(UuU\�VV\\V�V�WDW�W\�X/X}X\�Y\ZYiY�ZZVZ�Z�[E[�[\�\\5\\�\\\�]\']x]\�^\Z^l^�__a_�``W`�`�aOa�a�bIb�b�cCc�c\�d@d�d\�e=e�e\�f=f�f\�g=g�g\�h?h�h\�iCi�i�jHj�j�kOk�k�lWl�mm`m�nnkn\�ooxo\�p+p�p\�q:q�q�rKr�ss]s�ttpt\�u(u�u\�v>v�v�wVw�xxnx\�y*y�y\�zFz�{{c{\�|!|�|\�}A}�~~b~\�#�\�G���\n�k�͂0����W������\�G����r�ׇ;����i�Ή3�����d�ʋ0�����c�ʍ1�����f�Ώ6����n�֑?����z�\�M��� �����_�ɖ4���\n�u�\��L���$�����h�՛B��������d�Ҟ@��������i�ءG���&����v�\�V�ǥ8���\Z�����n�\�R�ĩ7�������u�\�\\�ЭD���-������\0�u�\�`�ֲK�³8���%�������y��h�\�Y�ѹJ�º;���.���!������\n�����z���p�\��g�\�\�_\�\�\�X\�\�\�Q\�\�\�K\�\�\�F\�\�\�Aǿ\�=ȼ\�:ɹ\�8ʷ\�6˶\�5̵\�5͵\�6ζ\�7ϸ\�9к\�<Ѿ\�?\��\�D\�\�\�I\�\�\�N\�\�\�U\�\�\�\\\�\�\�d\�\�\�l\��\�v\��ۀ\�܊\�ݖ\�ޢ\�)߯\�6\�\�D\�\�\�S\�\�\�c\�\�\�s\��\�\�\r\�\�\�\�2\�\�F\�\�\�[\�\�\�p\��\�\�\�\�(\�\�@\�\��X�\��r������4�\��P�\��m��������8�\��W�\��w����)���K�\��m��para\0\0\0\0\0\0\0\0ff\0\0�\0\0\rY\0\0\�\0\0\n[vcgt\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ndin\0\0\0\0\0\0\06\0\0�@\0\0U�\0\0L�\0\0��\0\0%�\0\0�\0\0P\0\0\0T@\033\033\033\0\0\0\0\0\0\0\0sf32\0\0\0\0\0r\0\0����\0\0�\0\0�r��������\0\0\�\0\0�qmmod\0\0\0\0\0\0\0\0�)\0\0\0\0\�\�\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0\04\0*\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0C\0\n\n\n\n\n\n\n\n\n�\�\0C	�\�\0\0�\�\0\0\0?\0�v\�i\�Q]�\�ESL�(��\��x��+��P(��u�\0\n]�\�(�\��|���+��P0(��\0(��\0�\��|��+��P(��\0(��\0�\�','erikatorio',2),(2,'�\��\�\0JFIF\0\0\0�\0�\0\0�\�\0tExif\0\0MM\0*\0\0\0\0\Z\0\0\0\0\0\0\0>\0\0\0\0\0\0\0F(\0\0\0\0\0\0\0�i\0\0\0\0\0\0\0N\0\0\0\0\0\0\0�\0\0\0\0\0\0�\0\0\0\0�\0\0\0\0\0\0\0N�\0\0\0\0\0\0\0L\0\0\0\0�\�\08Photoshop 3.0\08BIM\0\0\0\0\0\08BIM%\0\0\0\0\0\��ُ\0�\�	�\��B~�\�`ICC_PROFILE\0\0\0Pappl\0\0mntrRGB XYZ \�\0\0\0\0\0\"\07acspAPPL\0\0\0\0APPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\0\0\0\0\�-appl\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0desc\0\0P\0\0\0bdscm\0\0�\0\06cprt\0\0\�\0\0\0#wtpt\0\0\0\0\0rXYZ\0\0$\0\0\0gXYZ\0\08\0\0\0bXYZ\0\0L\0\0\0rTRC\0\0`\0\0aarg\0\0l\0\0\0 vcgt\0\0�\0\0\00ndin\0\0�\0\0\0>chad\0\0�\0\0\0,mmod\0\0(\0\0\0(bTRC\0\0`\0\0gTRC\0\0`\0\0aabg\0\0l\0\0\0 aagg\0\0l\0\0\0 desc\0\0\0\0\0\0\0Display\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0mluc\0\0\0\0\0\0\0#\0\0\0hrHR\0\0\0\0\0�koKR\0\0\0\0\0\�nbNO\0\0\0\0\0\�id\0\0\0\0\0\0\0\�huHU\0\0\0\0\0�csCZ\0\0\0\0\0daDK\0\0\0\0\0\"ukUA\0\0\0\0\0>ar\0\0\0\0\0\0\0ZitIT\0\0\0\0\0nroRO\0\0\0\0\0�nlNL\0\0\0\0\0�heIL\0\0\0\0\0�esES\0\0\0\0\0�fiFI\0\0\0\0\0�zhTW\0\0\0\0\0\�viVN\0\0\0\0\0\�skSK\0\0\0\0\0\�zhCN\0\0\0\0\0\�ruRU\0\0\0$\0\0\0frFR\0\0\0\0\0$ms\0\0\0\0\0\0\0:hiIN\0\0\0\0\0LcaES\0\0\0\0\0^thTH\0\0\0\0\0vesXL\0\0\0\0\0�deDE\0\0\0\0\0�enUS\0\0\0\0\0�ptBR\0\0\0\0\0�plPL\0\0\0\0\0�elGR\0\0\0\"\0\0\�svSE\0\0\0\0\0�trTR\0\0\0\0\0\0jaJP\0\0\0\0\0ptPT\0\0\0\0\0 \0L\0C\0D\0 \0u\0 \0b\0o\0j\0i\�\�\�\0 \0L\0C\0D\0F\0a\0r\0g\0e\0-\0L\0C\0D\0L\0C\0D\0 \0W\0a\0r\0n\0a\0S\0z\0\�\0n\0e\0s\0 \0L\0C\0D\0B\0a\0r\0e\0v\0n\0�\0 \0L\0C\0D\0L\0C\0D\0-\0f\0a\0r\0v\0e\0s\0k\0\�\0r\0m\Z>;L>@>289\0 \0L\0C\0D \0L\0C\0D\0 EDHF)\0L\0C\0D\0 \0c\0o\0l\0o\0r\0i\0L\0C\0D\0 \0c\0o\0l\0o\0r\0K\0l\0e\0u\0r\0e\0n\0-\0L\0C\0D \0L\0C\0D\0 \�\�\�\�\�\�\0V\0\�\0r\0i\0-\0L\0C\0D_i�r\0 \0L\0C\0D\0L\0C\0D\0 \0M\0\�\0u\0F\0a\0r\0e\0b\0n\0�\0 \0L\0C\0D&25B=>9\0 \Z\0-48A?;59\0L\0C\0D\0 \0c\0o\0u\0l\0e\0u\0r\0W\0a\0r\0n\0a\0 \0L\0C\0D	0			@	(\0 \0L\0C\0D\0L\0C\0D\0 \0e\0n\0 \0c\0o\0l\0o\0r\0L\0C\0D\0 *5\0F\0a\0r\0b\0-\0L\0C\0D\0C\0o\0l\0o\0r\0 \0L\0C\0D\0L\0C\0D\0 \0C\0o\0l\0o\0r\0i\0d\0o\0K\0o\0l\0o\0r\0 \0L\0C\0D��\��\���\0 ��\���\0 \0L\0C\0D\0F\0\�\0r\0g\0-\0L\0C\0D\0R\0e\0n\0k\0l\0i\0 \0L\0C\0D0�0\�0�\0L\0C\0D\0L\0C\0D\0 \0a\0 \0C\0o\0r\0e\0s\0\0text\0\0\0\0Copyright Apple Inc., 2018\0\0XYZ \0\0\0\0\0\0�\0\0\0\0\�XYZ \0\0\0\0\0\0q�\0\09�\0\0gXYZ \0\0\0\0\0\0a#\0\0�\�\0\0�XYZ \0\0\0\0\0\0#�\0\0�\0\0�\�curv\0\0\0\0\0\0\0\0\0\0\0\n\0\0\0\0\0#\0(\0-\02\06\0;\0@\0E\0J\0O\0T\0Y\0^\0c\0h\0m\0r\0w\0|\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0�\0\�\0\�\0\�\0\�\0\�\0\�\0\�\0\�\0�\0�\0�\r%+28>ELRY`gnu|���������\�\�\�\�\���&/8AKT]gqz�������\�\�\�\��\0!-8COZfr~�����\�\�\�\�� -;HUcq~����\�\�\���\r+:IXgw����\�\�\��\'7HYj{����\�\��+=Oat����\�\��2FZn����\�\��		%	:	O	d	y	�	�	�	\�	\�	�\n\n\'\n=\nT\nj\n�\n�\n�\n\�\n\�\n�\"9Qi���\�\��*C\\u���\��\r\r\r&\r@\rZ\rt\r�\r�\r\�\r\�\r�.Id��\�\�	%A^z��\�\�	&Ca~��\��1Om��\�\�&Ed��\�\�#Cc��\�\�\'Ij��\��4Vx��\�&Il��\��Ae��\��@e��\�� Ek��\�\Z\Z*\ZQ\Zw\Z�\Z\�\Z\�;c��\�*R{�\��Gp�\�\�@j��\�>i��\�  A l � \� �!!H!u!�!\�!�\"\'\"U\"�\"�\"\�#\n#8#f#�#\�#�$$M$|$�$\�%	%8%h%�%\�%�&\'&W&�&�&\�\'\'I\'z\'�\'\�(\r(?(q(�(\�))8)k)�)\�**5*h*�*\�++6+i+�+\�,,9,n,�,\�--A-v-�-\�..L.�.�.\�/$/Z/�/\�/�050l0�0\�11J1�1�1�2*2c2�2\�3\r3F33�3�4+4e4�4\�55M5�5\�5�676r6�6\�7$7`7�7\�88P8�8\�99B99�9�:6:t:�:\�;-;k;�;\�<\'<e<�<\�=\"=a=�=\�> >`>�>\�?!?a?�?\�@#@d@�@\�A)AjA�A\�B0BrB�B�C:C}C�DDGD�D\�EEUE�E\�F\"FgF�F�G5G{G�HHKH�H\�IIcI�I�J7J}J\�KKSK�K\�L*LrL�MMJM�M\�N%NnN�O\0OIO�O\�P\'PqP�QQPQ�Q\�R1R|R\�SS_S�S�TBT�T\�U(UuU\�VV\\V�V�WDW�W\�X/X}X\�Y\ZYiY�ZZVZ�Z�[E[�[\�\\5\\�\\\�]\']x]\�^\Z^l^�__a_�``W`�`�aOa�a�bIb�b�cCc�c\�d@d�d\�e=e�e\�f=f�f\�g=g�g\�h?h�h\�iCi�i�jHj�j�kOk�k�lWl�mm`m�nnkn\�ooxo\�p+p�p\�q:q�q�rKr�ss]s�ttpt\�u(u�u\�v>v�v�wVw�xxnx\�y*y�y\�zFz�{{c{\�|!|�|\�}A}�~~b~\�#�\�G���\n�k�͂0����W������\�G����r�ׇ;����i�Ή3�����d�ʋ0�����c�ʍ1�����f�Ώ6����n�֑?����z�\�M��� �����_�ɖ4���\n�u�\��L���$�����h�՛B��������d�Ҟ@��������i�ءG���&����v�\�V�ǥ8���\Z�����n�\�R�ĩ7�������u�\�\\�ЭD���-������\0�u�\�`�ֲK�³8���%�������y��h�\�Y�ѹJ�º;���.���!������\n�����z���p�\��g�\�\�_\�\�\�X\�\�\�Q\�\�\�K\�\�\�F\�\�\�Aǿ\�=ȼ\�:ɹ\�8ʷ\�6˶\�5̵\�5͵\�6ζ\�7ϸ\�9к\�<Ѿ\�?\��\�D\�\�\�I\�\�\�N\�\�\�U\�\�\�\\\�\�\�d\�\�\�l\��\�v\��ۀ\�܊\�ݖ\�ޢ\�)߯\�6\�\�D\�\�\�S\�\�\�c\�\�\�s\��\�\�\r\�\�\�\�2\�\�F\�\�\�[\�\�\�p\��\�\�\�\�(\�\�@\�\��X�\��r������4�\��P�\��m��������8�\��W�\��w����)���K�\��m��para\0\0\0\0\0\0\0\0ff\0\0�\0\0\rY\0\0\�\0\0\n[vcgt\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ndin\0\0\0\0\0\0\06\0\0�@\0\0U�\0\0L�\0\0��\0\0%�\0\0�\0\0P\0\0\0T@\033\033\033\0\0\0\0\0\0\0\0sf32\0\0\0\0\0r\0\0����\0\0�\0\0�r��������\0\0\�\0\0�qmmod\0\0\0\0\0\0\0\0�)\0\0\0\0\�\�\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0\0L\0N\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0C\0\n\n\n\n\n\n\n\n\n�\�\0C	�\�\0\0�\�\0\0\0?\0�㢊+չ\�QE \n(��\n(��\n(��?�\��㢊v\��R9\�\�N\�F\�|�6�v\�6\�\�h�m4\��\�QH�\��\�4�jӫ\�G8QI�KN\�S	\�%Jcu����QE��\��碊+\�9\����\n0)4(�\�Q�K�QO���PE?�R�\��碊+\�9(��(��(���ih�\��\�','haileesteinfeld',3);
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
