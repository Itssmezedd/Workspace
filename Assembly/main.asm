dosseg
    .model small
    .stack 0100h
.data

.code
start:
    mov ax, @data    ;to read .data section 
    mov ds, ax

    mov cx, 5
    row:
        push cx         ;store cx in top stack 

        mov ah, 2       ;request character
        mov dl,'a'      ;display character
        
        mov cx,5
        column:
            int 21h     ;print variable 
        loop column
     
        mov dl, 10     ;we can now use dl to nextline 
        int 21h         ;printnextline
        mov dl, bl       ;transfer back bl to dl
        
        pop cx           ;retrieve the current data from top stack 
    loop row

    mov ax, 4c00h   ;to end the code 
    int 21h
end start


