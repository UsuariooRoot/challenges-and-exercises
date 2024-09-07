function drawGift(size, symbol) {
  if (size == 1) return "#"
  let num = size - 2 // 3
  let gatos = "#".repeat(size)
  let cadena = " ".repeat(size-1) + gatos
  let symbols = symbol.repeat(num)
  let texto = "#" + symbols // #***
  let cadenaConcat = ""
  let cadenaConcat2 = ""

  for (let i = 0; i < num; i++) {
    cadenaConcat += "\n" + " ".repeat(num - i) + texto + "#" + symbol.repeat(i) + "#"
    cadenaConcat2 += "\n" + texto + "#" + symbol.repeat(num - (i+1)) + "#"
  }
  
  return cadena + cadenaConcat + "\n" + gatos + symbols + "#" + cadenaConcat2 + "\n" + gatos
}

drawGift(5, '*')
/*
    #####
   #***##
  #***#*#
 #***#**#
#####***#
#***#**#
#***#*#
#***##
#####
*/

// drawGift(4, '+')

/*
   ####
  #++##
 #++#+#
####++#
#++#+#
#++##
####
*/

// drawGift(1, '^')
/*
#
*/