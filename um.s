.data
	erro: .asciiz "0\nERRO"
	txtendl: .asciiz "\n"
.text
	# $t1: valor a ser lido
	# $t2: qnt de itens
	# $t3: soma	
	li $t2, 0
	li $t3, 0	
while:
	li $v0, 5
    	syscall
    	move $t1, $v0
	beq $t1, -1, exit
	add $t3, $t3, $t1
	add $t2, $t2, 1		
	j while

exit: 
	beqz $t2, zero
	#imprime soma
	li $v0, 1
	move $a0, $t3
	syscall
	
	#quebra
	li $v0, 4
	la $a0, txtendl
	syscall
	
	#calcula media
	div $t3, $t2
	mflo $a0
	
	#imprime media
	li $v0, 1
	syscall
	j end
zero:
	li $v0, 4
	la $a0, erro
	syscall
end:
	li $v0, 10
	syscall
