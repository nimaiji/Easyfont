# Easyfont

### Import EasyFont into your project and set your fonts files:
```java
/*
 *  Insert your regular font and bold font here ...
 */
private static String font = "Arial.ttf";
private static String boldFont = "ArialBold.ttf";
private static String buttonFont = "ArialItalic.ttf";  // if you set this string empty button's font will be regular font
private static String editTextFont = "ArialBoldItalic.ttf";    // if you set this string empty editText's font will be regular font
```
### Create new instance:
```java
EasyFont easyFont = new EasyFont(this);
easyFont.changeAllFonts();
```
Done!

## Extra:
* Set your element id (R.id.title) to set bold font.
* You can set fonts separatly
