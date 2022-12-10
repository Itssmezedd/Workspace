dosseg
    .model small
    .stack 0100h

.data
    b db 'program ends here!$'

.code
    start:

    mov ax, @data
    mov ds, ax

    mov cx, 26
    mov ah, 02h

    mov dl, 'a'
    a: int 21h
    mov bl, dl
    mov dl, 0ah
    int 21h
    mov dl, bl

    inc dl
    loop a

    mov ah, 09h
    mov dx, offset b
    int 21h

    mov ax, 4c00h 
    int 21h

    end start