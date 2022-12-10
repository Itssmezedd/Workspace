dosseg
    .model small
    .stack 0100h
.data

.code
    start:
    mov ax, @data    ;to read .data section 
    mov ds, ax

    mov ah, 2       ;request character
    mov dl, '9'     ;display variable 

    mov cx, 9           ;number of loops
    l1: 
        push cx         ;store cx in top stack 
        l2: ; 87654321 cx=0
            int 21h     ;print variable 
        loop l2
        mov bl, dl      ;temporary put dl variable to bl `
        mov dl, 10     ;we can now use dl to nextline 
        int 21h         ;printnextline
        mov dl, bl       ;transfer back bl to dl

        dec dl           ;decrement dl variable
        pop cx           ;retrieve the current data from top stack 
    loop l1 

    mov ax, 4c00h   ;to end the code 
    int 21h
    end start 