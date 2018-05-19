class Chopper

  def chop(n, array)
  	resultado = array.find_index(n)
  	if resultado == nil
  		resultado = -1
  	end
    return resultado
  end

  def sum(array)
  	if array.empty?
  		return 'vacio'
  	end

  	numeros = Hash.new("numero")
  	numeros = {0 => 'cero',
  			   1 => 'uno',
  			   2 => 'dos',
  			   3 => 'tres',
  			   4 => 'cuatro',
  			   5 => 'cinco',
  			   6 => 'seis',
  			   7 => 'siete',
  			   8 => 'ocho',
  			   9 => 'nueve'}
  	
  	suma = 0
  	array.each do |i|
  		suma += i
  	end

  	if suma >= 100
  		return 'demasiado grande'
  	end

  	return numeros[suma]
  end

end
